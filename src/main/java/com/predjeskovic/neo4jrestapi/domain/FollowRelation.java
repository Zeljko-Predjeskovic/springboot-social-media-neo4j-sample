package com.predjeskovic.neo4jrestapi.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDate;

@RelationshipProperties
@ToString
public class FollowRelation extends Persistable{


    @Property("followsSince")
    @Getter @Setter
    private LocalDate followsSince;

    @TargetNode
    @Getter
    private PersonNode person;

    private FollowRelation(){  }

    @Builder
    public FollowRelation(LocalDate followsSince, PersonNode person) {
        setFollowsSince(followsSince);
        this.person = person;
    }
}
