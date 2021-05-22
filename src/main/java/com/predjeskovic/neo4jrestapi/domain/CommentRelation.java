package com.predjeskovic.neo4jrestapi.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDate;

@RelationshipProperties
@EqualsAndHashCode @ToString
public class CommentRelation extends Persistable{

    @Getter
    private String comment;

    @Getter
    private LocalDate commentedOn;

    @TargetNode @Getter
    private PostNode post;

    public CommentRelation (){  }

    @Builder
    public CommentRelation(String comment, LocalDate commentedOn, PostNode post){
        this.comment = comment;
        this.commentedOn = commentedOn;
        this.post = post;
    }


}
