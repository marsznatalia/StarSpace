package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reactions")
public class Reaction {

    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @OneToMany(mappedBy = "reaction", cascade = CascadeType.ALL)
    private List<Like> likeList;


    public Reaction() {

    }

    public Reaction(long id, Post post, Comment comment, List<Like> likeList) {
        this.id = id;
        this.post = post;
        this.comment= comment;
        this.likeList = likeList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPostID() {
        return post;
    }

    public void setPostID(Post post) {
        this.post = post;
    }

    public Comment getCommentID() {
        return comment;
    }

    public void setCommentID(Comment comment) {
        this.comment = comment;
    }

    public List<Like> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<Like> likeList) {
        this.likeList = likeList;
    }
}


