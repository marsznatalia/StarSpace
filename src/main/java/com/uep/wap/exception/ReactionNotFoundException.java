package com.uep.wap.exception;

public class ReactionNotFoundException extends RuntimeException {
    public ReactionNotFoundException(Long id) {
        super("Could not find reaction by id: " + id);
    }
}
