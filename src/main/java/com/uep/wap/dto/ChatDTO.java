package com.uep.wap.dto;

import com.uep.wap.model.User;

import java.util.List;

public class ChatDTO {

    private String chatName;
    private Boolean chatType;
    private List<Long> helpListIds;
    private List<Long> usersInChatIds;
    private List<User> usersInChat;

    public String getChatName() {
        return chatName;
    }

    public Boolean getChatType() {
        return chatType;
    }

    public List<Long> getUsersInChatIds() {
        return usersInChatIds;
    }

    public List<Long> getHelpListIds() {
        return helpListIds;
    }
}
