package com.uep.wap.dto;

import com.uep.wap.model.User;

public class MessageDTO {

    private User whoSent;

    public User getWhoSent() {
        return whoSent;
    }

    public void setWhoSent(User whoSent) {
        this.whoSent = whoSent;
    }
}
