package com.food.location.presentation.controller;

import com.food.location.application.CreateCity.CreateCityCommand;
import com.food.location.application.CreateCity.CreateCityHandler;
import com.food.location.domain.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/city")
public class CreateCityController {

    @Autowired
    private CreateCityHandler handler;

    @PostMapping(value = "/create")
    public City invoke(@RequestBody Map<String, Object> parameters)
    {
        CreateCityCommand command = new CreateCityCommand(
                (String) parameters.get("name"), ((Integer)parameters.get("state_id")).shortValue()
        );

        return this.handler.handle(command);
    }
}
