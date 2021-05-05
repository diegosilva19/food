package com.food.restaurant.presentation.controller;

import com.food.restaurant.application.create.CreateHandler;
import com.food.restaurant.presentation.response.CreateResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/restaurant")
public class ListRestaurantController {

    private final CreateHandler handler;

    public ListRestaurantController(CreateHandler handler) {
        System.out.println("Instanciaou");
        this.handler = handler;
    }

    @GetMapping("list")
    @ResponseBody
    public String invoke() {
        CreateResponse response = this.handler.handler();

        return response.toResponse();
    }
}
