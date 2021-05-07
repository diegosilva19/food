package com.food.kitchen.presentation.controller;

import com.food.kitchen.application.CreateKitchen.CreateKitchenCommand;
import com.food.kitchen.application.CreateKitchen.CreateKitchenHandler;
import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/kitchens")
public class CreateKitchenController {

    @Autowired
    private CreateKitchenHandler handler;

    @PostMapping(path = "/create")
    public ResponseEntity<Kitchen> invoke(@RequestBody Map<String, Object> parameters) {
        CreateKitchenCommand command = new CreateKitchenCommand((String)parameters.get("name"));
        return ResponseEntity.status(HttpStatus.CREATED).body(this.handler.handle(command));
    }
}
