package com.food.location.presentation.controller;

import com.food.location.application.listStates.ListStatesHandler;
import com.food.location.domain.entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/state")
public class ListStatesController {

    @Autowired
    private ListStatesHandler handler;

    @GetMapping(value = "/list")
    @ResponseBody
    public List<State> invoke()
    {
        return this.handler.handle();
    }
}
