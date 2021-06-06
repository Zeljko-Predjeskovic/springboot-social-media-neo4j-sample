package com.predjeskovic.neo4jrestapi.presentation;

import com.predjeskovic.neo4jrestapi.service.PersonNodeDto;
import com.predjeskovic.neo4jrestapi.service.PersonService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;


    @Test
    void assertDelete() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/people/yatotoast"))
                .andDo(print())
                .andExpect(status().isOk());

        Mockito
                .verify(personService, times(1))
                .delete("yatotoast");
    }

    @Test
    void assertFindAll() throws Exception{
        when(personService.findAll())
                .thenReturn(List.of(
                        new PersonNodeDto(null,"Zeljko","Predjeskovic","yatotoast","xyz@gmail.com")
                ));

        mockMvc.perform(MockMvcRequestBuilders.get("/people"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("yatotoast")));
    }

}
