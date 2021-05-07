package com.food.kitchen.application.CreateKitchen;

import lombok.Getter;

import java.security.InvalidParameterException;

public class CreateKitchenCommand {
    @Getter
    private final String kitchenName;

    public CreateKitchenCommand(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidParameterException("Valor informado não é válido");
        }
        this.kitchenName = name;
    }
}
