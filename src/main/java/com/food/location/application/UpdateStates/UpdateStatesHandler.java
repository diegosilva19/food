package com.food.location.application.UpdateStates;

import com.food.location.application.FindStateById.FindStateByIdHandler;
import com.food.location.application.FindStateById.FindStateByIdQuery;
import com.food.location.domain.StateRepository;
import com.food.location.domain.entities.State;

import com.food.location.domain.exceptions.CannotBeUpdateStateException;
import com.food.location.domain.exceptions.NotFoundStateException;
import com.food.restaurant.domain.entity.Restaurant;
import com.food.shared.domain.application.mergeHttpPatchObjects.mergePatialObjectWithMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UpdateStatesHandler {

    @Autowired
    private StateRepository repository;

    @Autowired
    private FindStateByIdHandler finder;

    private State stateOnRequest;

    private State stateDatabase;

    public State handle(UpdateStatesCommand command)
    {
        this.stateOnRequest = command.getState();
        this.stateDatabase = this.finder.handle(new FindStateByIdQuery(stateOnRequest.getId()));

        this.updateFieldsDatabaseResultSet(command);

        try {
            this.stateDatabase = this.repository.save(this.stateDatabase);
        } catch (DataIntegrityViolationException exception) {
            throw new CannotBeUpdateStateException(stateOnRequest.getId());
        }

        return this.stateDatabase;
    }

    private void updateFieldsDatabaseResultSet(UpdateStatesCommand command)
    {
        if (command.getPartialFields() != null) {
            mergePatialObjectWithMap<State> parser = new mergePatialObjectWithMap<>(
                    command.getPartialFields(), this.stateDatabase
            );
            this.stateDatabase = parser.handle();
        } else {
            BeanUtils.copyProperties(this.stateOnRequest, this.stateDatabase);
        }
    }
}
