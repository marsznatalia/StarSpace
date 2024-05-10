package com.uep.wap.exception;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(long commentID) {
        super("Could not find comment by id: " + commentID);
    }
}
