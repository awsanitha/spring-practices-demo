package com.springpracticesdemo.exception;

import java.io.Serial;

public class BadRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7251559255487074264L;

    public BadRequestException(String message) {
        super(message);
    }
}
