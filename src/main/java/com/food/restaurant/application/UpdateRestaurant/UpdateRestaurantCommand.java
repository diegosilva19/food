package com.food.restaurant.application.UpdateRestaurant;

import com.food.restaurant.domain.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class UpdateRestaurantCommand {

    @Getter
    private final Restaurant restaurant;
}
