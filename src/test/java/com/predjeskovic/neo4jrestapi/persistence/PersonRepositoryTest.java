package com.predjeskovic.neo4jrestapi.persistence;

import com.predjeskovic.neo4jrestapi.domain.*;
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


    private PersonNode person;
    private PersonNode person2;

    @BeforeAll
    public void initBefore(){
        person = PersonNode.builder()
                .firstName("Zeljko")
                .lastName("Predjeskovic")
                .email("zepr2022000@gmail.com")
                .username("yatotoast")
                .profile(new ProfileNode("img.png","Hello World"))
                .build();

        person2 = PersonNode.builder()
                .firstName("Laura")
                .lastName("Steinberg")
                .email("xyz@gmail.com")
                .username("Nyumisa")
                .profile(new ProfileNode("img.png","Hello World"))
                .build();
    }

    @AfterAll
    public void initAfter(){
        personRepository.deleteAll();
        postRepository.deleteAll();
        profileRepositroy.deleteAll();
        advertisementRepository.deleteAll();
    }

    @Test
    @Order(1)
    public void insertPerson(){
        try {
            Assertions.assertTrue(personRepository.save(person) != null && personRepository.save(person2) != null);
        }
        catch (Exception e) {
            throw new RuntimeException("InsertPerson test failed",e);
        }
    }

    @Test
    @Order(2)
    public void findAllPerson(){
        var people = personRepository.findAllPeople();

        Assertions.assertTrue(!people.isEmpty() && people!=null);
    }

    @Test
    @Order(3)
    public void findByUsername(){
        var personX = personRepository.findByUsername("yatotoast");

        Assertions.assertTrue(personX!=null && personX.getId()!=null);
    }

    @Order(4)
    @Test
    public void addRelationBetweenTwoPersons(){
       var personX = personRepository.findByUsername("yatotoast");
       var personY = personRepository.findByUsername("Nyumisa");


        try {

            personX.followsPerson(FollowRelation.builder()
                    .followsSince(LocalDate.of(2016, 2, 26))
                    .person(personY)
                    .build());


            Assertions.assertTrue(personRepository.save(personX) != null);
        }
        catch (Exception e){
            throw new RuntimeException("AddRelationBetweenTwoPersons failed",e);
        }
    }


    @Order(5)
    @Test
    public void personCreatePost() {
        var personX = personRepository.findByUsername("yatotoast");

        personX.posted(PostNode.builder()
                .title("MyFirstPost")
                .cityLocation("Vienna")
                .tags("lol,Wien,meme")
                .description("Chillin with ma bois")
                .image("image.png")
                .build());

        personRepository.save(personX);

        var erg = personRepository.findByUsername("yatotoast").getPosts();

        Assertions.assertTrue(erg != null && !erg.isEmpty());
    }
}
