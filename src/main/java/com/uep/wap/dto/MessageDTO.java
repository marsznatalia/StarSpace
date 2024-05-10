package com.uep.wap.dto;


public class MessageDTO {

    private Long id;
    private Long senderId;
    private String messageContent;
    private Long chatId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public String getMessageContent() {
        return messageContent;
    }


    public Long getChatId() {
        return chatId;
    }
}
