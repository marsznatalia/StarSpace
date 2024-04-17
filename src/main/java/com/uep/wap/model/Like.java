package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "addressedTo")
    private Boolean addressedTo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "reaction_id")
    private Reaction reaction;

    public Like() {

    }

    public Like(long id, Boolean addressedTo, User user, Reaction reaction) {
        this.id = id;
        this.addressedTo = addressedTo;
        this.user = user;
        this.reaction = reaction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getAddressedTo() {
        return addressedTo;
    }

    public void setAddressedTo(Boolean addressedTo) {
        this.addressedTo = addressedTo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }
}


