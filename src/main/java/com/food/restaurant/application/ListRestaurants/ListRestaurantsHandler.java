package com.food.restaurant.application.ListRestaurants;

import com.food.restaurant.domain.RestaurantRepository;
import com.food.restaurant.domain.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListRestaurantsHandler {

    @Autowired
    private RestaurantRepository repository;

    public List<Restaurant> handle()
    {
        return this.repository.list();
    }
}
