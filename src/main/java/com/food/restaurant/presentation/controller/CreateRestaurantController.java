package com.food.restaurant.presentation.controller;

import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import com.food.restaurant.application.CreateRestaurant.CreateRestaurantCommand;
import com.food.restaurant.application.CreateRestaurant.CreateRestaurantHandler;
import com.food.restaurant.domain.entity.Restaurant;
import com.food.restaurant.presentation.response.CreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping(path = "/restaurants")
public class CreateRestaurantController {

    @Autowired
    private CreateRestaurantHandler handler;

    @PostMapping(value = "/create")
    public ResponseEntity<?> invoke(@RequestBody Restaurant restaurant) {
        try{
            CreateRestaurantCommand command = new CreateRestaurantCommand(restaurant);
            return ResponseEntity.status(HttpStatus.CREATED).body(this.handler.handler(command));
        } catch (NotFoundKitchenExeception kitchenExeception) {
            return ResponseEntity.badRequest().body(kitchenExeception.getMessage());
        }
    }
}
