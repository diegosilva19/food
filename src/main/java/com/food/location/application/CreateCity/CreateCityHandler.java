package com.food.location.application.CreateCity;

import com.food.location.application.FindStateById.FindStateByIdHandler;
import com.food.location.application.FindStateById.FindStateByIdQuery;
import com.food.location.domain.CityRepository;
import com.food.location.domain.entities.City;
import com.food.location.domain.entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCityHandler {

    @Autowired
    private CityRepository repository;

    @Autowired
    private FindStateByIdHandler finderState;

    public City handle(CreateCityCommand command)
    {
        City city = new City();
        State state = new State();

        state.setId(command.getStateId());

        city.setName(command.getName());
        city.setState(state);

        city = this.fetchStateDependecy(city);

        return this.repository.save(city);
    }

    private City fetchStateDependecy(City city)
    {
        State state = city.getState();

        if (state != null && state.getId() > 0) {
            city.setState(finderState.handle(new FindStateByIdQuery(state.getId())));
        }

        return city;
    }
}
