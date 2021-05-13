package com.food.location.application.DeleteCity;

import com.food.location.domain.CityRepository;
import com.food.location.domain.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class DeleteCityHandler {

    @Autowired
    private CityRepository repository;

    public boolean handle(DeleteCityCommand command)
    {
        City city = this.repository.findById(command.getCityId())
                .orElseThrow(() -> new EntityNotFoundException(
                    String.format("City: %d not found", command.getCityId())
                ));

        this.repository.delete(city);
        return true;
    }
}
