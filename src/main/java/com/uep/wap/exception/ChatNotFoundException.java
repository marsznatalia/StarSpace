package com.uep.wap.exception;

public class ChatNotFoundException extends RuntimeException {

    public ChatNotFoundException(Long id) {
        super("Could not find chat by id: " + id);
    }
}
