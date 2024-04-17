package com.uep.wap.model;

import javax.persistence.*;
import javax.persistence.Entity;

import java.util.List;

@Entity
@Table(name = "reactions")
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @OneToMany(mappedBy = "reaction", cascade = CascadeType.ALL)
    private List<Like> like;


    public Reaction() {

    }

    public Reaction(long id, Post post, Comment comment, List<Like> like) {
        this.id = id;
        this.post = post;
        this.comment = comment;
        this.like = like;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<Like> getLike() {
        return like;
    }

    public void setLike(List<Like> like) {
        this.like = like;
    }
}


