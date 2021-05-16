package com.predjeskovic.neo4jrestapi.persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.predjeskovic.neo4jrestapi.persistence.PersonReporitory;
import com.predjeskovic.neo4jrestapi.domain.Person;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonReporitory personReporitory;

    private Person person;
    private Person teammate;
    private Person teammate2;
    private Person teammate3;

    @BeforeEach
    void init(){
        person = new Person("Zeljko","Predjeskovic","123@mail.at");
        teammate = new Person("Kacper","Zaleski","123@mail.at");
        teammate2 = new Person("Dawud","Hussein","123@mail.at");
        teammate3 = new Person("Maximilian","Duranik","123@mail.at");

        personReporitory.save(teammate);
        personReporitory.save(teammate2);
        personReporitory.save(teammate3);

        person.worksWith(teammate);
        person.worksWith(teammate2);
        person.worksWith(teammate3);
        personReporitory.save(person);
    }

    @AfterEach
    void initAfter(){
        personReporitory.deleteAll();
    }

    @Test
    void findByLastName(){
        Assertions.assertEquals(personReporitory.findByLastName("Predjeskovic").getLastName(),person.getLastName());
    }

}
