package com.food.location.presentation.controller;

import com.food.location.application.UpdateStates.UpdateStatesCommand;
import com.food.location.application.UpdateStates.UpdateStatesHandler;
import com.food.location.domain.entities.State;
import com.food.location.domain.exceptions.CannotBeUpdateStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
@RestController
@RequestMapping(path = "/states")
public class UpdateStateController {

    @Autowired
    private UpdateStatesHandler handler;

    @PutMapping(value = "/{stateId}")
    public ResponseEntity<?> invoke(@PathVariable Short stateId, @RequestBody State state)
    {
        try{
            state.setId(stateId);
            UpdateStatesCommand command = new UpdateStatesCommand(state);
            return ResponseEntity.status(HttpStatus.OK).body(this.handler.handle(command));
        } catch (CannotBeUpdateStateException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
