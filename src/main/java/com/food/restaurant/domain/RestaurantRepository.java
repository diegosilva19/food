package com.food.restaurant.domain;

import com.food.restaurant.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RestaurantRepository {

    public List<Restaurant> list();

    public Restaurant searchById(Long id);

    public Restaurant save(Restaurant item);

    void delete(Restaurant item);
}
