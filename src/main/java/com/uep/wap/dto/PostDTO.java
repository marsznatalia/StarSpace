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
    private Long userAuthorId;
    private User user;

//    private Date datePosted;
//    private List<Comment> commentList;
//    private List<Reaction> reactionList;
//    private List<Comment> comments;
//    private List<Like> likes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserAuthorId() {
        return userAuthorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
