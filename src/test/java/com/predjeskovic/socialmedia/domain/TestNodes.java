package com.predjeskovic.socialmedia.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestNodes {

    @Test
    void verifyNewPersonNode(){
        var person = PersonNode.builder()
                .firstName("Zeljko")
                .lastName("Predjeskovic")
                .email("zepr2022000@gmail.com")
                .username("yatotoast")
                .profile(new ProfileNode("img.png","Hello World"))
                .build();

        Assertions.assertTrue(person!=null);
    }

    @Test
    void verifySamePersonNode(){
        var person = PersonNode.builder()
                .firstName("Zeljko")
                .lastName("Predjeskovic")
                .email("zepr2022000@gmail.com")
                .username("yatotoast")
                .profile(new ProfileNode("img.png","Hello World"))
                .build();

        var person2 = PersonNode.builder()
                .firstName("Zeljko")
                .lastName("Predjeskovic")
                .email("zepr2022000@gmail.com")
                .username("yatotoast")
                .profile(new ProfileNode("img.png","Hello World"))
                .build();

        Assertions.assertTrue(person.equals(person2));
    }

    @Test
    void verifyNotSamePersonNode(){
        var person = PersonNode.builder()
                .firstName("Zeljko")
                .lastName("Predjeskovic")
                .email("zepr2022000@gmail.com")
                .username("yatotoast")
                .profile(new ProfileNode("img.png","Hello World"))
                .build();

        var person2 = PersonNode.builder()
                .firstName("Zeljko")
                .lastName("Predjeskovic")
                .email("xyz@gmail.com")
                .username("notYatotoast")
                .profile(new ProfileNode("img.png","Hello World"))
                .build();

        Assertions.assertTrue(!person.equals(person2));
    }

    @Test
    void verifyNewPostNode(){
        var post = PostNode.builder()
                .cityLocation("Vienna")
                .tags("home,sleep,lazy")
                .description("laying in bed and doing nothing :3")
                .image("img.png")
                .build();

        Assertions.assertTrue(post!=null);
    }

    @Test
    void verifyNewAdNode(){
        var ad = AdvertisementNode.builder()
                .company("McDonals")
                .image("ad.png")
                .linkToProduct("www.mcdonalds.com")
                .tags("burger,mcdondals,fastfood")
                .build();

        Assertions.assertTrue(ad!=null);
    }
}
