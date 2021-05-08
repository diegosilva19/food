package com.food.shared.domain.exception;

public class EntityNotFoundException extends RuntimeException{

    static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
