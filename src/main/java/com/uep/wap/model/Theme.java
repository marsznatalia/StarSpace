package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "color") //Light theme to true, dark theme to false
    private boolean color;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Theme() {

    }

    public Theme(long id, boolean color, User user) {
        this.id = id;
        this.color = color;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


