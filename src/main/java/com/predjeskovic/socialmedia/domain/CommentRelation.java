package com.predjeskovic.socialmedia.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDate;

@RelationshipProperties
@ToString
public class CommentRelation extends Persistable{

    @Getter @Setter
    private String comment;

    @Getter @Setter
    private LocalDate commentedOn;

    @TargetNode
    @Getter
    private PostNode post;

    public CommentRelation (){  }

    @Builder
    public CommentRelation(String comment, LocalDate commentedOn, PostNode post){
        setComment(comment);
        setCommentedOn(commentedOn);
        this.post = post;
    }


}
