package com.food.restaurant.presentation.controller;

import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import com.food.restaurant.application.DeleteRestaurant.DeleteRestaurantCommand;
import com.food.restaurant.application.DeleteRestaurant.DeleteRestaurantHandler;
import com.food.restaurant.application.UpdateRestaurant.UpdateRestaurantCommand;
import com.food.restaurant.application.UpdateRestaurant.UpdateRestaurantHandler;
import com.food.restaurant.domain.entity.Restaurant;
import com.food.restaurant.domain.exception.NotFoundRestaurantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/restaurants")
public class DeleteRestaurantController {

    @Autowired
    private DeleteRestaurantHandler handler;

    @DeleteMapping(value = "/{restaurantId}")
    public ResponseEntity<String> invoke(@PathVariable Long restaurantId) {
        try{
            DeleteRestaurantCommand command = new DeleteRestaurantCommand(restaurantId);
            this.handler.handle(command);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch(NotFoundRestaurantException restaurantException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restaurantException.getMessage());
        }
    }
}
