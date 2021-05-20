package com.predjeskovic.neo4jrestapi.persistence;

import com.predjeskovic.neo4jrestapi.domain.FriendRelation;
import com.predjeskovic.neo4jrestapi.domain.PersonNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.predjeskovic.neo4jrestapi.domain.PersonNode;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PersonNodeRepositoryTest {

    @Autowired
    private PersonReporitory personReporitory;

    private PersonNode person;
    private PersonNode person1;
    private PersonNode person2;
    private PersonNode person3;

    @BeforeEach
    void init(){
        person = new PersonNode("Zeljko","Predjeskovic","Yatotoast","123@mail.at");
        person1 = new PersonNode("Kacper","Zaleski","K","123@mail.at");
        person2 = new PersonNode("Dawud","Hussein","D","123@mail.at");
        person3 = new PersonNode("Maximilian","Duranik","M","123@mail.at");

        person.friendsWith(new FriendRelation(LocalDate.now(),person1));
        person.friendsWith(new FriendRelation(LocalDate.now(),person2));
        person.friendsWith(new FriendRelation(LocalDate.now(),person3));

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
        PersonNode p = personReporitory.findByLastName("Predjeskovic");

        System.out.println(p);

        Assertions.assertEquals(p.getLastName(),person.getLastName());
    }

}
