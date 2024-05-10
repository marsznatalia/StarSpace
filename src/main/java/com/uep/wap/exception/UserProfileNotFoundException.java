package com.uep.wap.exception;

public class UserProfileNotFoundException extends RuntimeException {

    public UserProfileNotFoundException(Long id) {
        super("Could not find user profile by id: " + id);
    }
}
