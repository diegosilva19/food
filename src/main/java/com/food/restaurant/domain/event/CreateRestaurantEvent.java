package com.food.restaurant.domain.event;

import com.food.restaurant.domain.entity.Restaurant;

public class CreateRestaurantEvent {
    private Restaurant restaurant;

    public CreateRestaurantEvent(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "CreateRestaurantEvent{" +
                "com.food.food.restaurant=" + restaurant +
                '}';
    }
}
