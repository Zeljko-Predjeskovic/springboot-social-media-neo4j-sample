package com.predjeskovic.neo4jrestapi.persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.predjeskovic.neo4jrestapi.domain.Person;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonReporitory personReporitory;

    private Person person;
    private Person person1;
    private Person person2;
    private Person person3;

    @BeforeEach
    void init(){
        person = new Person("Zeljko","Predjeskovic","123@mail.at");
        person1 = new Person("Kacper","Zaleski","123@mail.at");
        person2 = new Person("Dawud","Hussein","123@mail.at");
        person3 = new Person("Maximilian","Duranik","123@mail.at");

        personReporitory.save(person);
        personReporitory.save(person);
        personReporitory.save(person);

        person.friendsWith(person1);
        person.friendsWith(person2);
        person.friendsWith(person3);
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
