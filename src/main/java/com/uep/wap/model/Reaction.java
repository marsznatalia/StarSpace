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
    private Post postID;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment commentID;

    @OneToMany(mappedBy = "reaction", cascade = CascadeType.ALL)
    private List<Like> likeList;


    public Reaction() {

    }

    public Reaction(long id, Post postID, Comment commentID, List<Like> likeList) {
        this.id = id;
        this.postID = postID;
        this.commentID = commentID;
        this.likeList = likeList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPostID() {
        return postID;
    }

    public void setPostID(Post post) {
        this.postID = post;
    }

    public Comment getCommentID() {
        return commentID;
    }

    public void setCommentID(Comment comment) {
        this.commentID = comment;
    }

    public List<Like> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<Like> likeList) {
        this.likeList = likeList;
    }
}


