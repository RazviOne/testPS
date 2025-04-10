package ro.tuc.ds2020.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ro.tuc.ds2020.Ds2020TestConfig;
import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.services.PersonService;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class PersonControllerUnitTest extends Ds2020TestConfig {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService service;

    @Test
    public void insertPersonTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PersonDTO personDTO = new PersonDTO("John", "johnutzu", "ciocanim", 0,
                false, false, "john.johnutzu@gmail.com", "0724917302",
                LocalDateTime.of(2000, 1, 1, 0, 0), "Suplacu de Barcau");

        mockMvc.perform(post("/person")
                .content(objectMapper.writeValueAsString(personDTO))
                .contentType("application/json"))
                .andExpect(status().isCreated());
    }

    @Test
    public void insertPersonTestFailsDueToAge() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PersonDTO personDTO = new PersonDTO("John", "johnutzu", "ciocanim", 0,
                false, false, "john.johnutzu@gmail.com", "0724917302",
                LocalDateTime.of(2000, 1, 1, 0, 0), "Suplacu de Barcau");

        mockMvc.perform(post("/person")
                .content(objectMapper.writeValueAsString(personDTO))
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void insertPersonTestFailsDueToNull() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PersonDTO personDTO = new PersonDTO("John", "johnutzu", "ciocanim", 0,
                false, false, "john.johnutzu@gmail.com", "0724917302",
                LocalDateTime.of(2000, 1, 1, 0, 0), "Suplacu de Barcau");

        mockMvc.perform(post("/person")
                .content(objectMapper.writeValueAsString(personDTO))
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

}
