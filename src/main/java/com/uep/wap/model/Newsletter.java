package com.uep.wap.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "newsletters")
public class Newsletter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "newsletter", cascade = CascadeType.ALL)
    private Set<News> newsList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "newsletter_user",
            joinColumns =
                    {@JoinColumn(name = "newsletter_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private User user;

    public Newsletter() {

    }

    public Newsletter(long id, String title, Set<News> newsList, User user) {
        this.id = id;
        this.title = title;
        this.newsList = newsList;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(Set<News> newsList) {
        this.newsList = newsList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


