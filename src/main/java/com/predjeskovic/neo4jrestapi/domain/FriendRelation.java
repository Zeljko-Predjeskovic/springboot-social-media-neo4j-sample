package com.predjeskovic.neo4jrestapi.domain;


import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDate;

@RelationshipProperties @Getter
public class FriendRelation extends Persistable{

    @Property
    private LocalDate friendSince;

    @TargetNode
    private PersonNode person;

    private FriendRelation(){  }

    public FriendRelation(LocalDate friendSince, PersonNode person) {
        this.friendSince = friendSince;
        this.person = person;
    }
}
