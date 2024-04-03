package com.uep.wap.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="userProfiles")
public class UserProfile {
    @Id
    @Column(name = "user_id")
    private Long id;
    @Column(name ="bio")
    private String bio;
    @Column(name ="profilePicture")
    private Object profilePicture;
    @Column(name ="status")
    private Integer status;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "links", joinColumns = @JoinColumn(name = "user_id")) //nie wiem czy Join Column is good
    @Column(name = "links", nullable = false)
    private List<String> links = new ArrayList<>();

    public UserProfile(){

    }

    public UserProfile(Long id, String bio, Object profilePicture, Integer status, User user, List<String> links) {
        this.id = id;
        this.bio = bio;
        this.profilePicture = profilePicture;
        this.status = status;
        this.user = user;
        this.links = links;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Object getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Object profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }
}


