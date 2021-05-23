package com.predjeskovic.neo4jrestapi.persistence;

import com.predjeskovic.neo4jrestapi.domain.FriendRelation;
import com.predjeskovic.neo4jrestapi.domain.PersonNode;
import com.predjeskovic.neo4jrestapi.domain.ProfileNode;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProfileRepositroy profileRepositroy;

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @AfterAll
    public void init(){
        personRepository.deleteAll();
        postRepository.deleteAll();
        profileRepositroy.deleteAll();
        advertisementRepository.deleteAll();
    }

    @Test
    @Order(1)
    public void insertPersons(){
        PersonNode person = PersonNode.builder()
                .firstName("Zeljko")
                .lastName("Predjeskovic")
                .email("zepr2022000@gmail.com")
                .username("yatotoast")
                .profile(new ProfileNode("img.png","Hello World"))
                .build();

        PersonNode person2 = PersonNode.builder()
                .firstName("Laura")
                .lastName("Steinberg")
                .email("xyz@gmail.com")
                .username("Nyumisa")
                .profile(new ProfileNode("img.png","Hello World"))
                .build();

        Assertions.assertTrue(personRepository.save(person)!=null && personRepository.save(person2)!=null);
    }

    @Test
    @Order(2)
    public void findAll(){
        var persons = personRepository.findAll();

        System.out.println(persons);

        Assertions.assertTrue(!persons.isEmpty() && persons!=null);
    }

    @Order(3)
    @Test void addRelationBetweenTwoPersons(){
       var person = personRepository.findByUsername("yatotoast");
       var person2 = personRepository.findByUsername("Nyumisa");

       person.friendsWith(FriendRelation.builder()
               .friendSince(LocalDate.now())
               .person(person2)
               .build());

       person2.friendsWith(new FriendRelation(LocalDate.now(), person));

       personRepository.save(person);
       personRepository.save(person2);

        System.out.println(personRepository.findAll());

    }


}
