package com.food.location.application.UpdateStates;

import com.food.location.domain.StateRepository;
import com.food.location.domain.entities.State;

import com.food.location.domain.exceptions.CannotBeUpdateStateException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
public class UpdateStatesHandler {

    @Autowired
    private StateRepository repository;

    public State handle(UpdateStatesCommand command)
    {
        State stateOnRequest = command.getState();
        State stateDatabase = this.repository.searchById(stateOnRequest.getId());

        if (stateDatabase == null) {
            throw new EntityNotFoundException(String.format("State : %d not found", stateOnRequest.getId()));
        }

        BeanUtils.copyProperties(stateOnRequest, stateDatabase);

        try {
            stateDatabase = this.repository.save(stateDatabase);
        } catch (DataIntegrityViolationException exception) {
            throw new CannotBeUpdateStateException(stateOnRequest.getId());
        }

        return stateDatabase;
    }
}
