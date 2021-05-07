package com.food.kitchen.presentation.controller;

import com.food.kitchen.application.CreateKitchen.CreateKitchenCommand;
import com.food.kitchen.application.CreateKitchen.CreateKitchenHandler;
import com.food.kitchen.application.UpdateKitchen.UpdateKitchenCommand;
import com.food.kitchen.application.UpdateKitchen.UpdateKitchenHandler;
import com.food.kitchen.domain.entity.Kitchen;
import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/kitchens")
public class UpdateKitchenController {

    @Autowired
    private UpdateKitchenHandler handler;

    @PutMapping(value = "/{kitchenId}")
    public ResponseEntity<?> invoke(@PathVariable Long kitchenId, @RequestBody Kitchen kitchen) {
        UpdateKitchenCommand command = new UpdateKitchenCommand(kitchenId, kitchen.getName());

        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.handler.handle(command));
        } catch (NotFoundKitchenExeception exeception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
