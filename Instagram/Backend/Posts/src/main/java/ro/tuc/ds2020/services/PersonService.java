package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.dtos.builders.PersonBuilder;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
    private final PersonRepository personRepository;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDTO> findPersons() {
        List<Person> personList = personRepository.findAll();
        return personList.stream()
                .map(PersonBuilder::toPersonDTO)
                .collect(Collectors.toList());
    }

    public List<PersonDTO> findAdmins() {
        List<Person> personList = personRepository.findAdminUsers();
        return personList.stream()
                .map(PersonBuilder::toPersonDTO)
                .collect(Collectors.toList());
    }

    public PersonDetailsDTO findPersonById(Integer id) {
        Optional<Person> prosumerOptional = personRepository.findById(id);

        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Person with id {} was not found in db", id);
            throw new ResourceNotFoundException(Person.class.getSimpleName() + " with id: " + id);
        }
        return PersonBuilder.toPersonDetailsDTO(prosumerOptional.get());
    }

    public Integer insert(PersonDetailsDTO personDTO) {
        Person person = PersonBuilder.toEntity(personDTO);
        person = personRepository.save(person);
        LOGGER.debug("Person with id {} was inserted in db", person.getId());
        return person.getId();
    }

    public void update(Integer id, PersonDetailsDTO personDetailsDTO) {
        Person person = PersonBuilder.toEntity(personDetailsDTO);
        person.setId(id);
        personRepository.save(person);
        LOGGER.debug("Person with id {} was updated in db", person.getId());
    }

    public void delete(Integer id){
        personRepository.deleteById(id);
    }

    public PersonDetailsDTO authenticateUser(String username, String password){
        Optional<Person> person = personRepository.findByUsername(username);

        if(person.isPresent()) {
            if(password.equals(person.get().getPassword())) {
                return PersonBuilder.toPersonDetailsDTO(person.get());
            }
            else{
                return null;
            }
        }
        return null;
    }

}
