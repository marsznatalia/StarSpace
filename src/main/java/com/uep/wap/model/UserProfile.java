package com.uep.wap.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "userProfiles")
public class UserProfile {
    @Id
    @Column(name = "user_id")
    private Long id;
    @Column(name = "bio")
    private String bio;
    @Lob
    @Column(name = "profilePicture", nullable = true)
    private byte[] profilePicture;
    @Column(name = "status")
    private Boolean status;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "links", joinColumns = @JoinColumn(name = "user_id")) //nie wiem czy Join Column is good
    @Column(name = "links", nullable = false)
    private Set<String> links = new HashSet<>();

    public UserProfile() {

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

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<String> getLinks() {
        return links;
    }

    public void setLinks(Set<String> links) {
        this.links = links;
    }
}


