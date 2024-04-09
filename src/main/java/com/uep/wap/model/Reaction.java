package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

//TODO: postId i commentId jako przechodnie id
//TODO: wygenerować konstruktor, gettery/settery

@Entity
@Table(name = "reactions")
public class Reaction {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Post comment;

    @OneToMany(mappedBy = "reaction", cascade = CascadeType.ALL)
    private List<Like> likeList;


    public Reaction() {

    }

}


