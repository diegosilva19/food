package com.food.restaurant.application.FindRestaurantById;

import com.food.restaurant.domain.RestaurantRepository;
import com.food.restaurant.domain.entity.Restaurant;
import com.food.restaurant.domain.exception.NotFoundRestaurantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindRestaurantByIdHandler {

    @Autowired
    private RestaurantRepository repository;

    public Restaurant handle(FindRestaurantByIdQuery query)
    {
        return this.repository.searchById(query.getId());
    }
}
