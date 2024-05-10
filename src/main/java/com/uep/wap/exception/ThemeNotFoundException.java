package com.uep.wap.exception;

public class ThemeNotFoundException extends RuntimeException {

    public ThemeNotFoundException(Long id) {
        super("Could not find chat by id: " + id);
    }
}
