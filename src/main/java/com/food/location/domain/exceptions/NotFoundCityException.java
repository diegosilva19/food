package com.food.location.domain.exceptions;

public class NotFoundCityException extends RuntimeException {
    static final long serialVersionUID = 1L;

    public NotFoundCityException(Short id) {
        super(String.format("City: %d not found", id));
    }
}
