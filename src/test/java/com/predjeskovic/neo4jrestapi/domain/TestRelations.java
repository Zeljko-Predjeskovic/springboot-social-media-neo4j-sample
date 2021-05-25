package com.predjeskovic.neo4jrestapi.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class TestRelations {

    private PersonNode person;
    private PersonNode person2;
    private PostNode post;

    @BeforeEach
    void init(){
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

        post = PostNode.builder()
                .description("Meme")
                .image("meme.png")
                .tags("meme,cool,lol,xD,toCoolForSchool")
                .cityLocation("Vienna")
                .build();
    }

    @Test
    void verifyFollowRelation(){
        person.followsPerson(FollowRelation.builder()
                .followsSince(LocalDate.now())
                .person(person2)
                .build());

        Assertions.assertTrue(person.getFollows()!=null);
        Assertions.assertTrue(person2.getFollows()==null);
    }

    @Test
    void verifyHasProfileRelation(){
        Assertions.assertTrue(person.getProfile()!=null);
        Assertions.assertTrue(person2.getProfile()!=null);
    }

    @Test
    void verifyPosted(){
        person2.posted(post);

        Assertions.assertTrue(person2.getPosts()!=null);
    }

    @Test
    void verifyCommentedOnRelation(){
    person.commentedOn(CommentRelation.builder()
            .comment("Lol, thats funny xD")
            .commentedOn(LocalDate.now())
            .post(post)
            .build());
        System.out.println(person.getCommentedOn());
    Assertions.assertTrue(!person.getCommentedOn().isEmpty() &&
                                  person.getCommentedOn()!=null);

    }

    @Test
    void verifyClickedOnAd(){
        person.clicked_On_ad(AdvertisementNode.builder()
                .company("McDonalds")
                .image("ad.png")
                .linkToProduct("www.mcdonalds.com")
                .tags("fastfood,burger,mcdonalds,imlovinit")
                .build());

        Assertions.assertTrue(!person.getAdvertisements().isEmpty() &&
                person.getAdvertisements()!=null);
    }

    @Test
    void verifyLikedPosts(){
        person.postLiked(post);

        Assertions.assertTrue(!person.getPostsLiked().isEmpty() &&
                                        person.getPostsLiked()!=null);
    }


}
