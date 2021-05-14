package com.food.location.application.DeleteStates;

import com.food.location.domain.StateRepository;
import com.food.location.domain.entities.State;
import com.food.location.domain.exceptions.CannotBeDeleteStateException;
import com.food.location.domain.exceptions.NotFoundStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class DeleteStatesHandler {

    @Autowired
    private StateRepository repository;

    public boolean handle(DeleteStatesCommand command)
    {
        State stateDatabase = this.repository.findById(command.getStateId())
                .orElseThrow(() -> new NotFoundStateException(command.getStateId()));

        try {
            this.repository.delete(stateDatabase);
        } catch(DataIntegrityViolationException exception) {
            throw new CannotBeDeleteStateException(command.getStateId());
        }

        return true;
    }
}
