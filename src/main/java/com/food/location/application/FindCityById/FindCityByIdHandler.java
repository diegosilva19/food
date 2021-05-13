package com.food.location.application.FindCityById;

import com.food.location.domain.CityRepository;
import com.food.location.domain.entities.City;
import com.food.location.domain.exceptions.NotFoundCityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCityByIdHandler {

    @Autowired
    private CityRepository repository;

    public City handle(FindCityByIdQuery query) {

        City city = this.repository.findById(query.getCityId())
                .orElseThrow(
                        () -> new NotFoundCityException(query.getCityId())
                );

        return city;
    }
}
