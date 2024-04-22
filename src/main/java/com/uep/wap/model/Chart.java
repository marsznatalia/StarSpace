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
    @Column(name = "content")
    private byte[] content;
    @Column(name = "type")
    private Integer type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_owner_id")
    private User userOwner;

    public Chart() {

    }

    public Chart(long id, String title, byte[] content, Integer type, User userOwner) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.userOwner = userOwner;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }
}


