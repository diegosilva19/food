package com.food.kitchen.application.DeleteKitchen;

import lombok.Getter;

public class DeleteKitchenCommand {

    @Getter
    private final Long kitchenId;

    public DeleteKitchenCommand(Long kitchenId) {
        this.kitchenId = kitchenId;
    }
}
