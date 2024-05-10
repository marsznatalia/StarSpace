package com.uep.wap.dto;

import com.uep.wap.model.News;
import com.uep.wap.model.User;

import java.util.Set;

public class NewsletterDTO {

    private String title;
    private long id;
    private Set<News> newsList;
    private User user;
    private Long userID;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

}
