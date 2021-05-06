package com.food.location.application.createCity;

import lombok.Getter;

public class CreateCityCommand {

    @Getter
    private final String name;
    @Getter
    private final Short stateId;

    public CreateCityCommand(String name, Short stateId)
    {
        this.name = name;
        this.stateId = stateId;
    }
}
