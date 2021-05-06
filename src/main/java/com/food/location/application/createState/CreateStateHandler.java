package com.food.location.application.createState;

import com.food.location.domain.StateRepository;
import com.food.location.domain.entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateStateHandler {

    @Autowired
    private StateRepository repository;

    public State handle(CreateStateCommand command)
    {
        State state = new State();
        state.setName(command.getName());
        state.setUf(command.getUf());
        return this.repository.save(state);
    }
}
