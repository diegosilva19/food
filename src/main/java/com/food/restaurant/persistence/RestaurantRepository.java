package com.food.restaurant.persistence;

import org.springframework.data.repository.CrudRepository;
import com.food.restaurant.domain.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
}
