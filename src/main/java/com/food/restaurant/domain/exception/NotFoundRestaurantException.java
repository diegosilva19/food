package com.food.restaurant.domain.exception;

public class NotFoundRestaurantException extends RuntimeException{

    static final long serialVersionUID = 1L;

    public NotFoundRestaurantException(Long restaurantId) {
        super(String.format("Restaurant %d Not Found", restaurantId));
    }

    public NotFoundRestaurantException(String message) {
        super(message);
    }
}
