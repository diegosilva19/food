package com.food.restaurant.application.UpdateRestaurant;

import com.food.restaurant.domain.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

public class UpdateRestaurantCommand {

    @Getter
    private Restaurant restaurant;

    @Getter
    @Setter
    private Map<String, Object> partialFields;

    public UpdateRestaurantCommand(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public UpdateRestaurantCommand(Long restaurantId, Map<String, Object> partialFields) {
        this.restaurant = new Restaurant();
        this.restaurant.setId(restaurantId);
        this.partialFields = partialFields;
    }
}
