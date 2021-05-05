package com.food.restaurant.presentation.response;

import com.food.restaurant.domain.entity.Restaurant;
import com.food.shared.domain.ResponseUseCase;


public class CreateResponse implements ResponseUseCase {

    private final Restaurant restaurant;

    public CreateResponse(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toResponse() {
        return this.restaurant.toString();
    }
}
