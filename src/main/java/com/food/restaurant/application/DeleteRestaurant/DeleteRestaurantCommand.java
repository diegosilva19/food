package com.food.restaurant.application.DeleteRestaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DeleteRestaurantCommand {

    @Getter
    private final Long restaurantId;
}
