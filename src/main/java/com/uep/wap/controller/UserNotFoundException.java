package com.uep.wap.controller;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not find user by id: " + id);
    }
}
