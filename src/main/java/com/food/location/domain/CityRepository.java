package com.food.location.domain;

import com.food.location.domain.entities.City;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CityRepository {

    public City searchById(Short id);

    public List<City> list();

    public City save(City city);

    void delete(City city);
}
