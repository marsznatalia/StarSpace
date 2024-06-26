package com.uep.wap.dto;

import com.uep.wap.model.User;

import java.util.Date;

public class PostDTO {
    private long id;
    private String content;
    private Date datePosted;
    private Long userAuthorId;
    private User user;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "userAuthorId=" + userAuthorId +
                ", content='" + content + '\'' +
                '}';
    }
}
