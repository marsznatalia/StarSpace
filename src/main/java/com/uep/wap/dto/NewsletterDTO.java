package com.uep.wap.dto;

import com.uep.wap.model.News;
import com.uep.wap.model.User;

import java.util.List;

public class NewsletterDTO {

    private String title;
    private long id;
    private List<News> newsList;
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
