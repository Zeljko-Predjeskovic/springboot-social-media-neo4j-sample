package com.predjeskovic.neo4jrestapi.persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.predjeskovic.neo4jrestapi.domain.Person;

import java.util.List;

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


        person2.friendsWith(person1); //Hussein friends with Zaleski

        person.friendsWith(person1); //friends with Zaleski
        person.friendsWith(person2); //friends with Hussein
        person.friendsWith(person3); //friends with Duranik
        personReporitory.save(person1);
        personReporitory.save(person2);
        personReporitory.save(person3);
        personReporitory.save(person);
    }

    @AfterEach
    void initAfter(){
      personReporitory.deleteAll();
    }

    @Test
    void findByLastName(){
        Person p = personReporitory.findByLastName("Predjeskovic");

        System.out.println(p);
        Assertions.assertEquals(p.getLastName(),person.getLastName());
    }

}
