package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "whoSent")
    private User whoSent;
    @Column(name = "whoReceived")
    private User whoReceived;
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    public Message() {
    }

    public Message(long id, User whoSent, User whoReceived, String content, Chat chat) {
        this.id = id;
        this.whoSent = whoSent;
        this.whoReceived = whoReceived;
        this.content = content;
        this.chat = chat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getWhoSent() {
        return whoSent;
    }

    public void setWhoSent(User whoSent) {
        this.whoSent = whoSent;
    }

    public User getWhoReceived() {
        return whoReceived;
    }

    public void setWhoReceived(User whoReceived) {
        this.whoReceived = whoReceived;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}


