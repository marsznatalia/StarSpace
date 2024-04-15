package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like {

    @Column(name = "user")
    private User user;
    @Column(name = "addressedTo")
    private Boolean addressedTo;

    @ManyToOne
    @JoinColumn(name = "reaction_id")
    private Reaction reaction;

    public Like() {

    }

    public Like(User user, Boolean addressedTo, Reaction reaction) {
        this.user = user;
        this.addressedTo = addressedTo;
        this.reaction = reaction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getAddressedTo() {
        return addressedTo;
    }

    public void setAddressedTo(Boolean addressedTo) {
        this.addressedTo = addressedTo;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }
}


