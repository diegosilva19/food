package com.food.location.application.ListCities;

import com.food.location.domain.CityRepository;
import com.food.location.domain.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListCitiesHandler {

    @Autowired
    private CityRepository repository;

    public List<City> handle()
    {
        return this.repository.list();
    }
}
