package com.food.location.application.CreateCity;

import com.food.location.domain.CityRepository;
import com.food.location.domain.entities.City;
import com.food.location.domain.entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCityHandler {

    @Autowired
    private CityRepository repository;

    public City handle(CreateCityCommand command)
    {
        City city = new City();
        State state = new State();

        state.setId(command.getStateId());

        city.setName(command.getName());
        city.setState(state);
        return this.repository.save(city);
    }
}
