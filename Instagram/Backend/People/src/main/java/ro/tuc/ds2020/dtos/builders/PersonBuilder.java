package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.entities.Person;

public class PersonBuilder {

    private PersonBuilder() {}

    public static PersonDTO toPersonDTO(Person person) {
        return new PersonDTO(person.getIdPerson(), person.getName(), person.getUsername(), person.getPassword(),
                person.getUserScore(), person.getIsAdmin(), person.getIsBanned(), person.getEmail(),
                person.getPhoneNumber(), person.getBirthDate(), person.getHomeCity());
    }

    public static Person toEntity(PersonDTO personDTO) {
        return new Person(personDTO.getName(), personDTO.getUsername(), personDTO.getPassword(),
                personDTO.getUserScore(), personDTO.getIsAdmin(), personDTO.getIsBanned(), personDTO.getEmail(),
                personDTO.getPhoneNumber(), personDTO.getBirthDate(), personDTO.getHomeCity());
    }

}
