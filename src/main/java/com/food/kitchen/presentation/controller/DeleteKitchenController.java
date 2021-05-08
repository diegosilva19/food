package com.food.kitchen.presentation.controller;

import com.food.kitchen.application.DeleteKitchen.DeleteKitchenCommand;
import com.food.kitchen.application.DeleteKitchen.DeleteKitchenHandler;
import com.food.kitchen.domain.exceptions.KitchenInUseExeception;
import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/kitchens")
public class DeleteKitchenController {

    @Autowired
    private DeleteKitchenHandler handler;

    @DeleteMapping(value = "/{kitchenId}")
    public ResponseEntity<String> invoke(@PathVariable Long kitchenId)
    {
        DeleteKitchenCommand command = new DeleteKitchenCommand(kitchenId);
        try {
            this.handler.handle(command);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch(NotFoundKitchenExeception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        } catch(KitchenInUseExeception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Exclusion Error: " + exception.getMessage());
        }
    }
}
