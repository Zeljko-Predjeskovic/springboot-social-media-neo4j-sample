package com.predjeskovic.neo4jrestapi.domain;


import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.lang.Nullable;


@Node("Post")
@ToString
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

    @Builder
    public PostNode(String description, String cityLocation, String image, String tags){
        this.description = description;
        this.cityLocation = cityLocation;
        this.image = image;
        this.description = description;
    }


    private PostNode(){  }



}
