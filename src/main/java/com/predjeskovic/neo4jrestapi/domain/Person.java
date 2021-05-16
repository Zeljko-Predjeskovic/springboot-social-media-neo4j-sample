package com.predjeskovic.neo4jrestapi.domain;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.Set;

@Node("Person") @Getter @Setter
@EqualsAndHashCode @ToString
public class Person extends Persistable{

    private Person() { }

    @Property("firstName")
    private String firstName;

    @Property("lastName")
    private String lastName;

    @Property("email")
    private String email;


    @Nullable
    @Relationship(type = "FRIENDS")
    private Set<Person> friends;


    public void friendsWith(Person person) {
        if (friends == null) {
            friends = new HashSet<>();
        }
        friends.add(person);
    }

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}


