package com.food.location.presentation.controller;

import com.food.location.application.ListCities.ListCitiesHandler;
import com.food.location.domain.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/city")
public class ListCitiesController {

    @Autowired
    private ListCitiesHandler handler;

    @GetMapping(value = "/list")
    public List<City> invoke()
    {
        return this.handler.handle();
    }
}
