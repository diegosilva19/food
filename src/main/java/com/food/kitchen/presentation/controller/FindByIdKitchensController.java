package com.food.kitchen.presentation.controller;

import com.food.kitchen.application.FindKitchenById.FindKitchenByIdHandler;
import com.food.kitchen.application.FindKitchenById.FindKitchenByIdQuery;
import com.food.kitchen.application.ListKitchens.ListKitchensHandler;
import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/kitchens")
public class FindByIdKitchensController {

    @Autowired
    private FindKitchenByIdHandler handler;

    @GetMapping(path = "/{kitchenId}")
    public ResponseEntity<Kitchen> invoke(@PathVariable Long kitchenId) {
        FindKitchenByIdQuery query = new FindKitchenByIdQuery(kitchenId);
        Kitchen foundItem = this.handler.handler(query);

        if (foundItem == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(foundItem);
    }
}
