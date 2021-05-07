package com.food.kitchen.application.UpdateKitchen;

import com.food.kitchen.domain.entity.Kitchen;
import lombok.Getter;

public class UpdateKitchenCommand {

    @Getter
    private final Kitchen kitchen;

    public UpdateKitchenCommand(Long kitchenId, String name) {
        this.kitchen = new Kitchen();
        this.kitchen.setName(name);
        this.kitchen.setId(kitchenId);
    }
}
