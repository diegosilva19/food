package com.food.restaurant.domain.event;

import com.food.restaurant.domain.entity.Restaurant;

public class UpdatedRestaurantEvent {
    private Restaurant restaurant;

    public UpdatedRestaurantEvent(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "UpdatedRestaurantEvent{" +
                "restaurant=" + restaurant +
                '}';
    }
}
