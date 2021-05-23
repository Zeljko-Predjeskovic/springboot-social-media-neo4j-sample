package com.predjeskovic.neo4jrestapi.domain;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDate;

@RelationshipProperties
@ToString
public class FriendRelation extends Persistable{

    @Property @Getter
    private LocalDate friendSince;

    @TargetNode @Getter
    private PersonNode person;

    private FriendRelation(){  }

    @Builder
    public FriendRelation(LocalDate friendSince, PersonNode person) {
        this.friendSince = friendSince;
        this.person = person;
    }
}
