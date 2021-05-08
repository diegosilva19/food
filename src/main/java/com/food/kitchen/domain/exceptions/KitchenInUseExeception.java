package com.food.kitchen.domain.exceptions;

public class KitchenInUseExeception extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public KitchenInUseExeception() {
        super("Kitchen Already in Use");
    }
}
