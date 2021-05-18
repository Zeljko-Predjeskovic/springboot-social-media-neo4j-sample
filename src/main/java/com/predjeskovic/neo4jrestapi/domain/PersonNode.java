package com.predjeskovic.neo4jrestapi.domain;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.Set;

@Node("Person") @Getter @Setter
@EqualsAndHashCode @ToString
public class PersonNode extends Persistable{

    private PersonNode() { }

    @Property("firstName")
    private String firstName;

    @Property("lastName")
    private String lastName;

    @Property("email")
    private String email;


    @Nullable
    @Relationship(type = "FRIENDS")
    private Set<PersonNode> friends;


    public void friendsWith(PersonNode person) {
        if (friends == null) {
            friends = new HashSet<>();
        }
        friends.add(person);
    }

    public PersonNode(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}


