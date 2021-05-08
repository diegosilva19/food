package com.food.location.presentation.controller;

import com.food.location.application.DeleteStates.DeleteStatesCommand;
import com.food.location.application.DeleteStates.DeleteStatesHandler;
import com.food.location.domain.exceptions.CannotBeDeleteStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(path = "/states")
public class DeleteStateController {

    @Autowired
    private DeleteStatesHandler handler;

    @DeleteMapping(value = "/{stateId}")
    public ResponseEntity<?> invoke(@PathVariable Short stateId)
    {
        try{
            DeleteStatesCommand command = new DeleteStatesCommand(stateId);
            this.handler.handle(command);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException exeception) {
            return ResponseEntity.notFound().build();
        } catch (CannotBeDeleteStateException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }
    }
}
