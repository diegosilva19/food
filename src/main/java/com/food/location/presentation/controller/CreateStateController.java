package com.food.location.presentation.controller;

import com.food.location.application.CreateState.CreateStateCommand;
import com.food.location.application.CreateState.CreateStateHandler;
import com.food.location.domain.entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/states")
public class CreateStateController {

    @Autowired
    private CreateStateHandler handler;

    @PostMapping(value = "/create")
    public State invoke(@RequestBody Map<String, Object> parameters)
    {
        CreateStateCommand command = new CreateStateCommand(
                (String) parameters.get("name"), (String) parameters.get("uf")
        );

        return this.handler.handle(command);
    }
}
