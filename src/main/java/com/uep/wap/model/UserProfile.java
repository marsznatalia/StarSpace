package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="userProfiles")
public class UserProfile {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name ="bio")
    private String bio;

    @Column(name ="profilePicture")
    private Object profilePicture;

    @Column(name="links")
    private List<String> links;
    @Column(name ="status")
    private Integer status;
    public UserProfile(){

    }

    public UserProfile(User user, String bio, Object profilePicture, List<String> links, Integer status) {
        this.user = user;
        this.bio = bio;
        this.profilePicture = profilePicture;
        this.links = links;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public String getBio() {
        return bio;
    }

    public Object getProfilePicture() {
        return profilePicture;
    }

    public List<String> getLinks() {
        return links;
    }

    public Integer getStatus() {
        return status;
    }
}


