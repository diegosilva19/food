package com.food.restaurant.presentation.controller;

import com.food.restaurant.application.create.CreateHandler;
import com.food.restaurant.presentation.response.CreateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/restaurants")
public class CreateRestaurantController {

    private final CreateHandler handler;

    public CreateRestaurantController(CreateHandler handler) {
        System.out.println("Instanciaou");
        this.handler = handler;
    }

    @PostMapping("/create")
    public String invoke() {
        CreateResponse response = this.handler.handler();
        return response.toResponse();
    }
}
