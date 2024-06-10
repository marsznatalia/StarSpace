package com.uep.wap.dto;

import com.uep.wap.model.User;

import java.util.List;

public class ChatDTO {

    private Long id;
    private String chatName;
    private Boolean chatType;
    private List<Long> helpListIds;
    private List<Long> usersInChatIds;
    private List<User> usersInChat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Long> getHelpListIds() {
        return helpListIds;
    }

    public void setHelpListIds(List<Long> helpListIds) {
        this.helpListIds = helpListIds;
    }

    public List<Long> getUsersInChatIds() {
        return usersInChatIds;
    }

    public void setUsersInChatIds(List<Long> usersInChatIds) {
        this.usersInChatIds = usersInChatIds;
    }

    public List<User> getUsersInChat() {
        return usersInChat;
    }

    public void setUsersInChat(List<User> usersInChat) {
        this.usersInChat = usersInChat;
    }

    @Override
    public String toString() {
        return "ChatDTO{" +
                "chatName='" + chatName + '\'' +
                ", chatType=" + chatType +
                ", helpListIds=" + helpListIds +
                ", usersInChatIds=" + usersInChatIds +
                ", usersInChat=" + usersInChat +
                '}';
    }
}
