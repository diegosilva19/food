package com.food.location.application.UpdateStates;

import com.food.location.domain.entities.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class UpdateStatesCommand
{
    @Getter
    private final State state;

    @Getter
    @Setter
    private Map<String, Object> partialFields;

    public UpdateStatesCommand(State state)
    {
        this.state = state;
    }

    public UpdateStatesCommand(Short stateId, Map<String, Object> partialFields)
    {
        this.state = new State();
        this.state.setId(stateId);
        this.partialFields = partialFields;
    }
}
