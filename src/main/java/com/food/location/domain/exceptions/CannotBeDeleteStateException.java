package com.food.location.domain.exceptions;

public class CannotBeDeleteStateException extends RuntimeException {
    static final long serialVersionUID = 1L;

    public CannotBeDeleteStateException(Short id) {
        super(String.format("State: %d already in use , cannot be deleted", id));
    }
}
