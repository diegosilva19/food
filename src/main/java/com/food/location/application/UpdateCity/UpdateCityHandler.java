package com.food.location.application.UpdateCity;

import com.food.location.domain.CityRepository;
import com.food.location.domain.StateRepository;
import com.food.location.domain.entities.City;
import com.food.location.domain.entities.State;
import com.food.location.domain.exceptions.NotFoundCityException;
import com.food.location.domain.exceptions.NotFoundStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCityHandler {

    @Autowired
    private CityRepository repository;

    @Autowired
    private StateRepository repositoryState;

    public City handle(UpdateCityCommand command)
    {
        City city = this.repository.findById(command.getCity().getId())
                .orElseThrow(() -> new NotFoundCityException(command.getCity().getId()));

        city = this.fetchStateDependecy(city);

        this.repository.save(city);

        return city;
    }

    private City fetchStateDependecy(City city) {

        State state = city.getState();

        if (state != null && state.getId() > 0) {
            State stateDatabase = this.repositoryState.searchById(state.getId());

            if (stateDatabase == null) {
                throw new NotFoundStateException(state.getId());
            }
            state = stateDatabase;
        }

        city.setState(state);
        return city;
    }
}
