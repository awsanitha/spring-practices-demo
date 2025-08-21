package com.springpracticesdemo.exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -6960286429292643521L;

    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
