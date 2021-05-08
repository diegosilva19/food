package com.food.restaurant.application.CreateRestaurant;

import com.food.kitchen.domain.entity.Kitchen;
import com.food.restaurant.domain.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

public class CreateRestaurantCommand {

    @Getter
    private String name;

    @Getter
    private BigDecimal feeTransportTaxe;

    @Getter
    private Restaurant restaurant;

    public CreateRestaurantCommand(String name, BigDecimal feeTransportTaxe) {
        this.name = name;
        this.feeTransportTaxe = feeTransportTaxe;
    }

    public CreateRestaurantCommand(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
