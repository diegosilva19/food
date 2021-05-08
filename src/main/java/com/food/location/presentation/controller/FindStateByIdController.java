package com.food.location.presentation.controller;

import com.food.location.application.FindStateById.FindStateByIdHandler;
import com.food.location.application.FindStateById.FindStateByIdQuery;
import com.food.location.domain.entities.State;
import com.food.location.domain.exceptions.NotFoundStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/states")
public class FindStateByIdController {

    @Autowired
    private FindStateByIdHandler handler;

    @GetMapping(value = "/{stateId}")
    public ResponseEntity<State> invoke(@PathVariable Short stateId)
    {
        try{
            FindStateByIdQuery command = new FindStateByIdQuery(stateId);
            return ResponseEntity.status(HttpStatus.OK).body(this.handler.handle(command));
        }  catch (NotFoundStateException exeception) {
            return ResponseEntity.notFound().build();
        }
    }
}
