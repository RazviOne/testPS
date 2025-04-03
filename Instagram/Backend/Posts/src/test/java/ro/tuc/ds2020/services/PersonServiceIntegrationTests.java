package ro.tuc.ds2020.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ro.tuc.ds2020.Ds2020TestConfig;
import ro.tuc.ds2020.dtos.PostDTO;
import ro.tuc.ds2020.dtos.PostDetailsDTO;

import static org.springframework.test.util.AssertionErrors.assertEquals;

import java.util.List;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/create.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/delete.sql")
public class PersonServiceIntegrationTests extends Ds2020TestConfig {

    @Autowired
    PostService personService;

    @Test
    public void testGetCorrect() {
        List<PostDTO> personDTOList = personService.findPersons();
        assertEquals("Test Insert Person", 1, personDTOList.size());
    }

    @Test
    public void testInsertCorrectWithGetById() {
        PostDetailsDTO p = new PostDetailsDTO("johnutzu", "ciocanim", "John", "Somewhere Else street", 22, false);
        Integer insertedID = personService.insert(p);

        PostDetailsDTO insertedPerson = new PostDetailsDTO(insertedID, p.getUsername(), p.getPassword(), p.getName(),p.getAddress(), p.getAge(), p.getIsAdmin());
        PostDetailsDTO fetchedPerson = personService.findPersonById(insertedID);

        assertEquals("Test Inserted Person", insertedPerson, fetchedPerson);
    }

    @Test
    public void testInsertCorrectWithGetAll() {
        PostDetailsDTO p = new PostDetailsDTO("johnutzu", "ciocanim", "John", "Somewhere Else street", 22, false);
        personService.insert(p);

        List<PostDTO> personDTOList = personService.findPersons();
        assertEquals("Test Inserted Persons", 2, personDTOList.size());
    }

}
