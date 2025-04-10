package ro.tuc.ds2020.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ro.tuc.ds2020.Ds2020TestConfig;
import ro.tuc.ds2020.dtos.PersonDTO;

import static org.springframework.test.util.AssertionErrors.assertEquals;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/create.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/delete.sql")
public class PersonServiceIntegrationTests extends Ds2020TestConfig {

    @Autowired
    PersonService personService;

    @Test
    public void testGetCorrect() {
        List<PersonDTO> personDTOList = personService.findPersons();
        assertEquals("Test Insert Person", 1, personDTOList.size());
    }

    @Test
    public void testInsertCorrectWithGetById() {
        PersonDTO p = new PersonDTO("John", "johnutzu", "ciocanim", 0, false,
                false, "john.johnutzu@gmail.com", "0724917302",
                LocalDateTime.of(2000, 1, 1, 0, 0), "Suplacu de Barcau");
        Integer insertedID = personService.insert(p);
        PersonDTO insertedPerson = new PersonDTO(insertedID, p.getName(), p.getUsername(), p.getPassword(),
                p.getUserScore(), p.getIsAdmin(), p.getIsBanned(), p.getEmail(), p.getPhoneNumber(), p.getBirthDate(),
                p.getHomeCity());
        PersonDTO fetchedPerson = personService.findPersonById(insertedID);

        assertEquals("Test Inserted Person", insertedPerson, fetchedPerson);
    }

    @Test
    public void testInsertCorrectWithGetAll() {
        PersonDTO p = new PersonDTO("John", "johnutzu", "ciocanim", 0, false,
                false, "john.johnutzu@gmail.com", "0724917302",
                LocalDateTime.of(2000, 1, 1, 0, 0), "Suplacu de Barcau");
        personService.insert(p);

        List<PersonDTO> personDTOList = personService.findPersons();
        assertEquals("Test Inserted Persons", 2, personDTOList.size());
    }

}
