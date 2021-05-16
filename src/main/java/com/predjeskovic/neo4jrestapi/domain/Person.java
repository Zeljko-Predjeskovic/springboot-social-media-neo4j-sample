package com.predjeskovic.neo4jrestapi.domain;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Node @Getter @Setter
@EqualsAndHashCode @ToString
public class Person {


    private Person() {

    }

    @Id @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @Nullable
    @Relationship(type = "TEAMMATE")
    private Set<Person> teammates;


    public void worksWith(Person person) {
        if (teammates == null) {
            teammates = new HashSet<>();
        }
        teammates.add(person);
    }

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}


