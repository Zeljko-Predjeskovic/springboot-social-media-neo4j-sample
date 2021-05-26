package com.predjeskovic.neo4jrestapi.service;

import com.predjeskovic.neo4jrestapi.domain.PersonNode;
import com.predjeskovic.neo4jrestapi.domain.ProfileNode;

public class PersonNodeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private ProfileNode profile;

    public PersonNodeDto(Long id, String firstName, String lastName, String username,
                         String email, ProfileNode profile)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.profile = profile;
    }

    public static  PersonNodeDto fromPersonNode(PersonNode person){
        return new PersonNodeDto(
                person.getId(),
                person.getFirstName(),
                person.getFirstName(),
                person.getLastName(),
                person.getUsername(),
                person.getProfile());
    }

    public PersonNode toPersonNode(){
        return PersonNode.builder()
                .firstName(firstName)
                .lastName(lastName)
                .username(username)
                .email(email)
                .profile(profile)
                .build();
    }

    public PersonNode mergeWith(PersonNode person){
        PersonNode personR = PersonNode.builder()
                .firstName(firstName)
                .lastName(lastName)
                .username(username)
                .email(email)
                .profile(profile)
                .build();

        personR.setId(person.getId());

        return personR;
    }

}

