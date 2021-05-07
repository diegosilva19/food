package com.food.kitchen.application.FindKitchenById;

public class FindKitchenByIdQuery {

    private final Long kitchenId;

    public FindKitchenByIdQuery(Long kitchenId) {

        this.kitchenId = kitchenId;
    }

    public Long getKitchenId() {
        return this.kitchenId;
    }
}
