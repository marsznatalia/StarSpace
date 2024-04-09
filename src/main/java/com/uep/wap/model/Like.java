package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like {

    @Column(name = "user")
    private User user;
    @Column(name = "addressedTo")
    private Boolean addressedTo;

    //@ManyToOne
    //@JoinColumn(name = "reaction_id")
    //private Reaction reaction;
    //TODO: w kodzie powyżej trzeba jakoś połączyć Reaction.java z Like.java, ale mamy dwa id, ponieważ to tabela przechodna; następnie wygenerować constructor i gettery/settery

    public Like() {

    }

}


