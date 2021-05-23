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
    public void initbefore(){
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
    public void insertPersons(){
        Assertions.assertTrue(personRepository.save(person)!=null && personRepository.save(person2)!=null);
    }

    @Test
    @Order(2)
    public void findAll(){
        var persons = personRepository.findAll();

        Assertions.assertTrue(!persons.isEmpty() && persons!=null);
    }

    @Order(3)
    @Test
    public void addRelationBetweenTwoPersons(){
       var personX = personRepository.findByUsername("yatotoast");
       var personY = personRepository.findByUsername("Nyumisa");

       person.friendsWith(FriendRelation.builder()
               .friendSince(LocalDate.of(2016,2,26))
               .person(personY)
               .build());

       Assertions.assertTrue(personRepository.save(personX)!=null);

       person2.friendsWith(FriendRelation.builder()
               .friendSince(LocalDate.of(2016,2,26))
               .person(personX)
               .build());

       Assertions.assertTrue(personRepository.save(personY)!=null);



    }

    @Order(4)
    @Test
    public void createAndLikeCommentPost(){
        var personX = personRepository.findByUsername("yatotoast");
        var personY = personRepository.findByUsername("Nyumisa");
        PostNode post = PostNode.builder()
                .description("Look at my cute little kitty")
                .image("cat.png")
                .cityLocation("Berlin")
                .tags("cat,cute,adorable")
                .build();

        personX.posted(post);

        Assertions.assertTrue(personRepository.save(personX)!=null);

        personY.postLiked(post); //should fail. we have to take the post from the db since the id will be null until the db generates it
        personY.commentedOn(CommentRelation.builder()
                .post(post)
                .commentedOn(LocalDate.now())
                .comment("Soooo cuuute >.<")
                .build());

        Assertions.assertTrue(personRepository.save(personY)!=null);
    }

}
