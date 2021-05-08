package com.food.location.application.DeleteStates;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DeleteStatesCommand
{
    @Getter
    private final Short stateId;
}
