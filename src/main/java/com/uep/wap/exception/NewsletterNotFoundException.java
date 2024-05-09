package com.uep.wap.exception;

public class NewsletterNotFoundException extends RuntimeException {
    public NewsletterNotFoundException(Long id) {
        super("Could not find newsletter by id: " + id);
    }
}
