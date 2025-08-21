package com.springpracticesdemo.exception;

import java.io.Serial;

public class ConflictException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8972560933550881722L;

    public ConflictException(String message) {
        super(message);
    }
}
