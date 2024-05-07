package com.uep.wap.dto;

import com.uep.wap.model.*;

import java.util.Date;
import java.util.List;

public class CommentDTO {

    private String content;
    private Date datePosted;
    private User author;
    private Post post;
    private Comment parent;
    private List<Reaction> reactionList; //TODO: skoro może nie być reakcji zadnej, to czy my tutaj to deklarujemy?
    private List<Comment> children; //TODO: jw
    private List<Like> likes; //TODO: jw

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public List<Reaction> getReactionList() {
        return reactionList;
    }

    public void setReactionList(List<Reaction> reactionList) {
        this.reactionList = reactionList;
    }

    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }
}
