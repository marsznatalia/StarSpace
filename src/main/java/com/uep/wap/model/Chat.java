package com.uep.wap.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="students")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;
    @Column(name ="chatName")
    private String chatName;
    @Column(name ="chatType")
    private Boolean chatType;

    //Todo: usersInChat as List of Users
//    @ElementCollection(targetClass = User.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "usersInChat", joinColumns = @JoinColumn(name = "user_id")) //nie wiem czy Join Column is good
//    @Column(name = "usersInChat", nullable = false)
//    private List<User> usersInChat = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Chat(){

    }

    public Chat(long id, String chatName, Boolean chatType, User user) {
        this.id = id;
        this.chatName = chatName;
        this.chatType = chatType;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public Boolean getChatType() {
        return chatType;
    }

    public void setChatType(Boolean chatType) {
        this.chatType = chatType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


