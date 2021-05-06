package com.food.location.presentation.controller;

import com.food.location.application.listCities.ListCitiesHandler;
import com.food.location.domain.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/city")
public class ListCitiesController {

    @Autowired
    private ListCitiesHandler handler;

    @GetMapping(value = "/list")
    @ResponseBody
    public List<City> invoke()
    {
        return this.handler.handle();
    }
}
