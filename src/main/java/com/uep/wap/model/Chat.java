package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "chatName")
    private String chatName;

    @Column(name = "chatType")
    private Boolean chatType;

    @OneToMany(mappedBy = "inChat")
    private Set<Message> messagesList = new HashSet<>();
    // lista wiadomości w chacie

    @ManyToMany
    @JoinTable(
            name = "chat_users",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> chatUsersList = new HashSet<>(); //lista userów którzy są w danym chacie

    public Chat() {
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

    public Set<Message> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(Set<Message> messagesList) {
        this.messagesList = messagesList;
    }

    public Set<User> getChatUsersList() {
        return chatUsersList;
    }

    public void setChatUsersList(Set<User> chatUsersList) {
        this.chatUsersList = chatUsersList;
    }
}


