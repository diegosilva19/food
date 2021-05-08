package com.food.location.domain.exceptions;

public class NotFoundStateException extends RuntimeException {
    static final long serialVersionUID = 1L;

    public NotFoundStateException(Short id) {
        super(String.format("State: %d not found", id));
    }
}
