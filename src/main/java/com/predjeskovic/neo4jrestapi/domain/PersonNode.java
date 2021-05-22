package com.predjeskovic.neo4jrestapi.domain;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

@Node("Person")
@EqualsAndHashCode @ToString
public class PersonNode extends Persistable{

    private PersonNode() { }

    @Property("firstName")
    @Getter @Setter
    private String firstName;

    @Property("lastName")
    @Getter @Setter
    private String lastName;

    @Property("username")
    @Getter @Setter
    private String username;

    @Property("email")
    @Getter @Setter
    private String email;

    @Relationship(value = "HAS_PROFILE", direction = Relationship.Direction.INCOMING)
    @Getter @Setter
    private ProfileNode profile;

    @Nullable @Getter
    @Relationship(type = "FOLLOWS")
    private List<FriendRelation> friends;

    public void friendsWith(FriendRelation friend) {
        if (friends == null) {
            friends = new ArrayList<FriendRelation>();
        }
        friends.add(friend);
    }

    @Nullable @Getter
    @Relationship(type = "COMMENTED_ON")
    private List<CommentRelation> commentedOn;

    public void commentedOn(CommentRelation comment){
        if(commentedOn == null){
            commentedOn = new ArrayList<CommentRelation>();
        }
        else{
            commentedOn.add(comment);
        }
    }

    @Nullable @Getter
    @Relationship(type = "POSTED")
    private List<PostNode> posts;

    public void posted(PostNode post){
        if(posts == null){
            posts = new ArrayList<PostNode>();
        }
        else{
            posts.add(post);
        }
    }

    @Nullable @Getter
    @Relationship(type = "CLICKED_ON")
    private List<AdvertisementNode> advertisements;

    public void clicked_On_ad(AdvertisementNode advertisement){
        if(advertisements == null){
            advertisements = new ArrayList<AdvertisementNode>();
        }
        else{
            advertisements.add(advertisement);
        }

    }

    @Nullable @Getter
    @Relationship(type = "LIKES")
    private List<PostNode> postsLiked;

    public void postLiked(PostNode post){
        if(postsLiked == null){
            postsLiked = new ArrayList<PostNode>();
        }
        else{
            postsLiked.add(post);
        }
    }

    @Builder
    public PersonNode(String firstName, String lastName, String username, String email, ProfileNode profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.profile = profile;
    }

}


