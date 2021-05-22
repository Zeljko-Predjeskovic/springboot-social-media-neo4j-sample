package com.predjeskovic.neo4jrestapi.domain;


import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.TargetNode;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;


@Node("Post")
@EqualsAndHashCode @ToString
public class PostNode extends Persistable{

    @Property("description")
    @Getter @Setter
    private String description;

    @Property("city")
    @Getter @Setter
    private String cityLocation;

    @Property("image")
    @Getter @Setter
    private String image;

    @Property("tags")
    @Nullable @Getter @Setter
    private String tags;

    @Relationship(type="LIKES", direction = Relationship.Direction.INCOMING)
    @Getter @Nullable
    private List<PersonNode> personsLiked;

    @Relationship(value = "COMMENTED_ON", direction = Relationship.Direction.INCOMING)
    @Getter @Nullable
    private List<CommentRelation> comments;

    @Builder
    public PostNode(String description, String cityLocation, String image, String tags){
        this.description = description;
        this.cityLocation = cityLocation;
        this.image = image;
        this.description = description;
    }


    private PostNode(){  }

}
