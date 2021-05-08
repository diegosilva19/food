package com.food.location.application.UpdateStates;

import com.food.location.domain.entities.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class UpdateStatesCommand
{
    @Getter
    private final State state;
}
