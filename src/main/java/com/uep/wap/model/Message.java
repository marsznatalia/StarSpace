package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User whoSent;

    @ManyToOne
    private Chat inChat;

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getWhoSent() {
        return whoSent;
    }

    public void setWhoSent(User whoSent) {
        this.whoSent = whoSent;
    }

    public Chat getInChat() {
        return inChat;
    }

    public void setInChat(Chat inChat) {
        this.inChat = inChat;
    }
}


