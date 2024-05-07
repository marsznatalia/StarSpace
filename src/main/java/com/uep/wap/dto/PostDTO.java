package com.uep.wap.dto;

import com.uep.wap.model.Comment;
import com.uep.wap.model.Like;
import com.uep.wap.model.Reaction;
import com.uep.wap.model.User;

import java.util.Date;
import java.util.List;

public class PostDTO {
    private long id;
    private String content;
    private Date datePosted;
    private Long userAuthorId;
    private User user;
    private List<Comment> commentList;
    private List<Reaction> reactionList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public Long getUserAuthorId() {
        return userAuthorId;
    }

    public void setUserAuthorId(Long userAuthorId) {
        this.userAuthorId = userAuthorId;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Reaction> getReactionList() {
        return reactionList;
    }

    public void setReactionList(List<Reaction> reactionList) {
        this.reactionList = reactionList;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    private List<Comment> comments;
    private List<Like> likes;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
