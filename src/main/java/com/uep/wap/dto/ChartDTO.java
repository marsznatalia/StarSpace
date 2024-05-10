package com.uep.wap.dto;

import com.uep.wap.model.User;

public class ChartDTO {
    private byte[] content;
    private String title;
    private Integer type;
    private User userOwner;

    public String getTitle() {
        return title;
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

    public User getUserOwner() {
        return userOwner;
    }

}
