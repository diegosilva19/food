package com.food.location.application.FindStateById;

import com.food.location.domain.StateRepository;
import com.food.location.domain.entities.State;
import com.food.location.domain.exceptions.NotFoundStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindStateByIdHandler {

    @Autowired
    private StateRepository repository;

    public State handle(FindStateByIdQuery query)
    {
        State state = this.repository.searchById(query.getStateId());

        if (state == null) {
            throw new NotFoundStateException(query.getStateId());
        }

        return state;
    }
}
