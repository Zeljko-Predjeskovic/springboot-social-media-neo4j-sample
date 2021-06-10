package com.predjeskovic.socialmedia.domain;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.lang.Nullable;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Node("Person")
public class PersonNode extends Persistable{

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

    @Relationship(value = "HAS_PROFILE")
    @Getter @Setter
    private ProfileNode profile;

    @Nullable @Getter
    @Relationship(type = "FOLLOWS")
    private List<FollowRelation> follows;

    public void followsPerson(FollowRelation followedPerson) {
        if (follows == null) {
            follows = new ArrayList<FollowRelation>();
        }
        follows.add(followedPerson);
    }

    @Nullable @Getter
    @Relationship(type = "COMMENTED_ON")
    private List<CommentRelation> commentedOn;

    public void commentedOn(CommentRelation comment){
        if(commentedOn == null){
            commentedOn = new ArrayList<CommentRelation>();
        }
            commentedOn.add(comment);
    }

    @Nullable @Getter
    @Relationship(type = "POSTED")
    private List<PostNode> posts;

    public void posted(PostNode post){
        if(posts == null){
            posts = new ArrayList<PostNode>();
        }
            posts.add(post);
    }

    @Nullable @Getter
    @Relationship(type = "CLICKED_ON")
    private List<AdvertisementNode> advertisements;

    public void clicked_On_ad(AdvertisementNode advertisement){
        if(advertisements == null){
            advertisements = new ArrayList<AdvertisementNode>();
        }
            advertisements.add(advertisement);

    }

    @Nullable @Getter
    @Relationship(type = "LIKES")
    private List<PostNode> postsLiked;

    public void postLiked(PostNode post){
        if(postsLiked == null){
            postsLiked = new ArrayList<PostNode>();
        }
            postsLiked.add(post);
    }

    protected PersonNode() { }

    @Builder
    public PersonNode(String firstName, String lastName, String username, String email, ProfileNode profile) {
        setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setEmail(email);
        setProfile(profile);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonNode that = (PersonNode) o;
        return username.equals(that.username) || email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email);
    }


    @Override
    public String toString() {
        // showing the usernames by the followers
        // prevents recursive toString
        List<String> str = follows.stream().map(f-> f.getPerson().getUsername()).collect(Collectors.toList());

        return "PersonNode{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                ", follows=" + str +
                ", commentedOn=" + commentedOn +
                ", posts=" + posts +
                ", advertisements=" + advertisements +
                ", postsLiked=" + postsLiked +
                '}';
    }
}


