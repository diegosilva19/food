package com.food.location.presentation.controller;

import com.food.location.application.CreateCity.CreateCityCommand;
import com.food.location.application.CreateCity.CreateCityHandler;
import com.food.location.domain.entities.City;
import com.food.location.domain.exceptions.NotFoundStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/cities")
public class CreateCityController {

    @Autowired
    private CreateCityHandler handler;

    @PostMapping(value = "/create")
    public ResponseEntity<?> invoke(@RequestBody Map<String, Object> parameters)
    {
        try {
            CreateCityCommand command = new CreateCityCommand(
                    (String) parameters.get("name"), ((Integer)parameters.get("state_id")).shortValue()
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(this.handler.handle(command));
        } catch(NotFoundStateException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }
    }
}
