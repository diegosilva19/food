package com.food.restaurant.application.DeleteRestaurant;

import com.food.restaurant.domain.RestaurantRepository;
import com.food.restaurant.domain.entity.Restaurant;
import com.food.restaurant.domain.exception.NotFoundRestaurantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteRestaurantHandler {

    @Autowired
    private RestaurantRepository repository;

    public boolean handle(DeleteRestaurantCommand command)
    {
        Restaurant restaurant = this.repository.findById(command.getRestaurantId()).orElseThrow(
                () -> new NotFoundRestaurantException(command.getRestaurantId())
        );

        this.repository.delete(restaurant);

        return true;
    }
}
