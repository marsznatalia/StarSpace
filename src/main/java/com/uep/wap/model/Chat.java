package com.uep.wap.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "chatName")
    private String chatName;
    @Column(name = "chatType")
    private Boolean chatType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<Message> messageList;

    @ElementCollection(targetClass = User.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "usersInChat", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "usersInChat", nullable = false)
    private List<User> usersInChat = new ArrayList<>();

    public Chat() {
    }

    public Chat(long id, String chatName, Boolean chatType, User user, List<Message> messageList, List<User> usersInChat) {
        this.id = id;
        this.chatName = chatName;
        this.chatType = chatType;
        this.user = user;
        this.messageList = messageList;
        this.usersInChat = usersInChat;
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

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<User> getUsersInChat() {
        return usersInChat;
    }

    public void setUsersInChat(List<User> usersInChat) {
        this.usersInChat = usersInChat;
    }
}


