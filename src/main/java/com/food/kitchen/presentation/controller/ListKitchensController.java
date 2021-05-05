package com.food.kitchen.presentation.controller;

import com.food.kitchen.application.ListKitchens.ListKitchensHandler;
import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/kitchen")
public class ListKitchensController {

    @Autowired
    private final ListKitchensHandler handler;

    public ListKitchensController(ListKitchensHandler handler) {
        this.handler = handler;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Kitchen> invoke() {
        return this.handler.handler();
    }
}
