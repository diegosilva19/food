package com.food.location.presentation.controller;

import com.food.location.application.createCity.CreateCityCommand;
import com.food.location.application.createCity.CreateCityHandler;
import com.food.location.application.listCities.ListCitiesHandler;
import com.food.location.domain.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/city")
public class CreateCityController {

    @Autowired
    private CreateCityHandler handler;

    @PostMapping(value = "/create")
    @ResponseBody
    public City invoke(@RequestBody Map<String, Object> parameters)
    {
        CreateCityCommand command = new CreateCityCommand(
                (String) parameters.get("name"), ((Integer)parameters.get("state_id")).shortValue()
        );

        return this.handler.handle(command);
    }
}
