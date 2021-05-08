package com.food.location.application.UpdateCity;

import com.food.location.domain.entities.City;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class UpdateCityCommand {

    @Getter
    private City city;
}
