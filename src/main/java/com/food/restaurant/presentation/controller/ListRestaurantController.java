package com.food.restaurant.presentation.controller;

import com.food.restaurant.application.ListRestaurants.ListRestaurantsHandler;
import com.food.restaurant.domain.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/restaurants")
public class ListRestaurantController {

    @Autowired
    private ListRestaurantsHandler handler;

    @GetMapping(value = "/list")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Restaurant> invoke() {
        return this.handler.handle();
    }
}
