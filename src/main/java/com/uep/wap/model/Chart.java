package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name = "charts")
public class Chart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "userOwner")
    private User userOwner;
    @Column(name = "content")
    private Object content;
    @Column(name = "type")
    private Integer type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Chart() {

    }

    public Chart(long id, String title, User userOwner, Object content, Integer type, User user) {
        this.id = id;
        this.title = title;
        this.userOwner = userOwner;
        this.content = content;
        this.type = type;
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

    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


