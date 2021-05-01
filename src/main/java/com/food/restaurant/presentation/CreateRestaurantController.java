package com.food.restaurant.presentation;

import com.food.restaurant.application.create.CreateHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/restaurant")
public class CreateRestaurantController {

    private final CreateHandler handler;

    public CreateRestaurantController(CreateHandler handler) {
        System.out.println("Instanciaou");
        this.handler = handler;
    }

    @GetMapping("create")
    @ResponseBody
    public String invoke() {
        CreateResponse response = this.handler.handler();

        return response.toResponse();
    }
}
