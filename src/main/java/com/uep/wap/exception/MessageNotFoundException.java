package com.uep.wap.exception;

public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(Long id) {
        super("Could not find message by id: " + id);
    }
}
