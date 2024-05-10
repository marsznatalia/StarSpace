package com.uep.wap.model;

import javax.persistence.*;
import java.util.HashSet;
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
    @CollectionTable(name = "links", joinColumns = @JoinColumn(name = "user_id"))
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

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
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

    public void setLinks(Set<String> links) {
        this.links = links;
    }
}


