package com.uep.wap.exception;

public class NewsNotFoundException extends RuntimeException{
    public NewsNotFoundException(Long id) {
        super("Could not find news by id: " + id);
    }
}
