package com.predjeskovic.neo4jrestapi.Domain;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Node @Getter @Setter @Builder @NoArgsConstructor
@EqualsAndHashCode @ToString
public class Person {

    @Id @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @Relationship(type = "TEAMMATE")
    private Set<Person> teammates;


    public void worksWith(Person person) {
        if (teammates == null) {
            teammates = new HashSet<>();
        }
        teammates.add(person);
    }


}


