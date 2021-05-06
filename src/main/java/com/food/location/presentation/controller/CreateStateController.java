package com.food.location.presentation.controller;

import com.food.location.application.createState.CreateStateCommand;
import com.food.location.application.createState.CreateStateHandler;
import com.food.location.domain.entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path = "/state")
public class CreateStateController {

    @Autowired
    private CreateStateHandler handler;

    @PostMapping(value = "/create")
    @ResponseBody
    public State invoke(@RequestBody Map<String, Object> parameters)
    {
        CreateStateCommand command = new CreateStateCommand(
                (String) parameters.get("name"), (String) parameters.get("uf")
        );

        return this.handler.handle(command);
    }
}
