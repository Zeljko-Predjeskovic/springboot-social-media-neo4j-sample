package com.predjeskovic.neo4jrestapi.domain;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Profile")
@ToString
public class ProfileNode extends Persistable{

    @Property("profilePicture")
    private String profilePic;

    @Property("biography")
    private String biography;

    private ProfileNode() {  }

    @Builder
    public ProfileNode(String profilePic, String biography){
        this.profilePic = profilePic;
        this.biography = biography;
    }


}
