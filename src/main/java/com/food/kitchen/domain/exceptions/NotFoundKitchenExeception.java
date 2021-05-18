package com.food.kitchen.domain.exceptions;

public class NotFoundKitchenExeception extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundKitchenExeception() {
        super("Kitchen Not Found");
    }

    public NotFoundKitchenExeception(Long id) {
        super(String.format("Kitchen %d Not Found", id));
    }
}
