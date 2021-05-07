package com.food.kitchen.domain.exceptions;

public class NotFoundKitchenExeception extends Exception {

    public NotFoundKitchenExeception() {
        super("Kitchen Not Found");
    }
}
