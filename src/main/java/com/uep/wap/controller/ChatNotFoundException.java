package com.uep.wap.controller;

public class ChatNotFoundException extends RuntimeException {

    public ChatNotFoundException(Long id) {
        super("Could not find chat by id: " + id);
    }
}
