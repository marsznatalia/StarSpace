package com.uep.wap.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long id) {
        super("Could not find post by id: " + id);
    }
}
