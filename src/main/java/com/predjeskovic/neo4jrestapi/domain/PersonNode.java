package com.predjeskovic.neo4jrestapi.domain;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

@Node("Person") @Getter @Setter
@EqualsAndHashCode @ToString
public class PersonNode extends Persistable{

    private PersonNode() { }

    @Property("firstName")
    private String firstName;

    @Property("lastName")
    private String lastName;


    @Property("username")
    private String username;

    @Property("email")
    private String email;

    @Nullable
    @Relationship(type = "FRIENDS", direction = Relationship.Direction.INCOMING)
    private List<FriendRelation> friends;


    public void friendsWith(FriendRelation friend) {
        if (friends == null) {
            friends = new ArrayList<FriendRelation>();
        }
        friends.add(friend);
    }

    public PersonNode(String firstName, String lastName, String username, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

}


