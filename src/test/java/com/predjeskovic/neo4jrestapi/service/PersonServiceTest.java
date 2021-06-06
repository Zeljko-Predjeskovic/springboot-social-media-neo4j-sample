package com.predjeskovic.neo4jrestapi.service;

import com.predjeskovic.neo4jrestapi.persistence.PersonRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    private PersonNodeDto person = new PersonNodeDto(null,"Zeljko","Predjeskovic","yatotoast",
                "xyz@gmail.com");

    @AfterAll
    public void initAfter(){
        personRepository.deleteAll();
    }

    @Order(1)
    @Test
    public void VerifyInsert(){
        PersonNodeDto insertPerson = personService.insert(this.person);

        Assertions.assertTrue(insertPerson.toPersonNode().getUsername().equals(this.person.getUsername()));
    }

    @Order(2)
    @Test
    public void verifyFindAll(){
        List<PersonNodeDto> persons = personService.findAll();

        Assertions.assertTrue((!persons.isEmpty() || persons!=null));
    }

    @Order(3)
    @Test
    public void verifyReplace(){
        person = new PersonNodeDto(null,"Zeljko","Steinberg","yatotoast",
                "xyz@gmail.com");

        Assertions.assertTrue(personService.replace("yatotoast",person)!=null);
    }

    @Order(4)
    @Test
    public void verifyDelete(){
        personService.delete(person.getUsername());

        Assertions.assertTrue(personService.findAll().isEmpty());
    }
}