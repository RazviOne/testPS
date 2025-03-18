package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.services.PersonService;

import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public ResponseEntity<List<PersonDTO>> getPersons() {
        List<PersonDTO> dtos = personService.findPersons();
        for (PersonDTO dto : dtos) {
            Link personLink = linkTo(methodOn(PersonController.class)
                    .getPersonById(dto.getId())).withRel("personDetails");
            dto.add(personLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Integer> insertPerson(@Valid @RequestBody PersonDetailsDTO personDTO) {
        Integer personID = personService.insert(personDTO);
        return new ResponseEntity<>(personID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDetailsDTO> getPersonById(@PathVariable("id") Integer personId) {
        PersonDetailsDTO failedDto = new PersonDetailsDTO();
        failedDto.setId(-1);
        try {
            PersonDetailsDTO dto = personService.findPersonById(personId);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(failedDto, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/authenticate/{username}/{password}")
    public ResponseEntity<PersonDetailsDTO> authenticateUser(@PathVariable("username") String username,
                                                             @PathVariable("password") String password) {
        PersonDetailsDTO failedDto = new PersonDetailsDTO();
        failedDto.setId(-1);
        try {
            PersonDetailsDTO dto = personService.authenticateUser(username, password);
            if(dto == null){
                return new ResponseEntity<>(failedDto, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(failedDto, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<PersonDetailsDTO> updatePerson(@Valid @RequestBody PersonDetailsDTO personDetailsDTO,
                                                         @PathVariable("id") Integer personId){
        PersonDetailsDTO failedDto = new PersonDetailsDTO();
        failedDto.setId(-1);
        try {
            personService.findPersonById(personId);
            personService.update(personId, personDetailsDTO);
            return new ResponseEntity<>(personDetailsDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(failedDto, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/admins")
    public ResponseEntity<List<PersonDTO>> getAdmins(){
        List<PersonDTO> dtos = personService.findAdmins();
        for (PersonDTO dto : dtos) {
            Link personLink = linkTo(methodOn(PersonController.class)
                    .getPersonById(dto.getId())).withRel("personDetails");
            dto.add(personLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PersonDetailsDTO> deletePerson(@PathVariable("id") Integer personId){
        PersonDetailsDTO failedDto = new PersonDetailsDTO();
        failedDto.setId(-1);
        try {
            PersonDetailsDTO dto = personService.findPersonById(personId);
            personService.delete(personId);

            try {
                URL url = new URL("http://localhost:8081/deviceLink/person/" + personId);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");
                int status = connection.getResponseCode();
                System.out.print("Status: " + status + "\n");
                return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
            } catch (Exception e){
                return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(failedDto, HttpStatus.NOT_FOUND);
        }
    }

}
