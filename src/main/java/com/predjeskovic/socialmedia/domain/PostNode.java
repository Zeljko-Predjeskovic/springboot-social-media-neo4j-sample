package com.predjeskovic.socialmedia.domain;


import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.lang.Nullable;


@Node("Post")
@ToString
public class PostNode extends Persistable{

    @Property("title")
    @Getter @Setter
    private String title;

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

    private PostNode(){  }

    @Builder
    public PostNode(String title, String description, String cityLocation, String image, String tags){
        setTitle(title);
        setDescription(description);
        setCityLocation(cityLocation);
        setImage(image);
        setTags(tags);
    }


}
