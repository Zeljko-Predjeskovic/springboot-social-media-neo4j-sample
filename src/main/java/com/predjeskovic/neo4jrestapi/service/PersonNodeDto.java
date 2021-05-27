package com.predjeskovic.neo4jrestapi.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.predjeskovic.neo4jrestapi.domain.PersonNode;
import com.predjeskovic.neo4jrestapi.domain.ProfileNode;
import lombok.Getter;

public class PersonNodeDto {

    @Getter
    private Long id;

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String username;

    @Getter
    private String email;

    @Getter
    private ProfileNode profile;

    public PersonNodeDto(Long id, String firstName, String lastName, String username,
                         String email)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

    public static  PersonNodeDto fromPersonNode(PersonNode person){
        return new PersonNodeDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getUsername(),
                person.getEmail());
    }

    public PersonNode toPersonNode(){
        var person = PersonNode.builder()
                .firstName(firstName)
                .lastName(lastName)
                .username(username)
                .email(email)
                .profile(profile)
                .build();

        person.setId(id);

        return person;
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

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public static PersonNodeDto fromJsonAttributes(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("username") String username,
            @JsonProperty("email") String email){
        return new PersonNodeDto(null,firstName,lastName,username,email);
    }

}

