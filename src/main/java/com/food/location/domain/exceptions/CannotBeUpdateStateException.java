package com.food.location.domain.exceptions;

public class CannotBeUpdateStateException extends RuntimeException {
    static final long serialVersionUID = 1L;

    public CannotBeUpdateStateException(Short id) {
        super(String.format("State: %d cannot be update , check fields was sent", id));
    }
}
