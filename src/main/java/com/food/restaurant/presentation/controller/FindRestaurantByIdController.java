package com.food.restaurant.presentation.controller;

import com.food.restaurant.application.FindRestaurantById.FindRestaurantByIdHandler;
import com.food.restaurant.application.FindRestaurantById.FindRestaurantByIdQuery;
import com.food.restaurant.domain.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/restaurants")
public class FindRestaurantByIdController {

    @Autowired
    private FindRestaurantByIdHandler handler;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> invoke(@PathVariable Long restaurantId) {
        FindRestaurantByIdQuery query = new FindRestaurantByIdQuery(restaurantId);
        Restaurant restaurant = this.handler.handle(query);

        if (restaurant == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }
}
