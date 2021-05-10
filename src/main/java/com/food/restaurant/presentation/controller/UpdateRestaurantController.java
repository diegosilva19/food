package com.food.restaurant.presentation.controller;

import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import com.food.restaurant.application.UpdateRestaurant.UpdateRestaurantCommand;
import com.food.restaurant.application.UpdateRestaurant.UpdateRestaurantHandler;
import com.food.restaurant.domain.entity.Restaurant;
import com.food.restaurant.domain.exception.NotFoundRestaurantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/restaurants")
public class UpdateRestaurantController {

    @Autowired
    private UpdateRestaurantHandler handler;

    @PutMapping(value = "/{restaurantId}")
    public ResponseEntity<?> invoke(@PathVariable Long restaurantId,  @RequestBody Restaurant restaurant) {
        try{
            restaurant.setId(restaurantId);
            UpdateRestaurantCommand command = new UpdateRestaurantCommand(restaurant);
            return ResponseEntity.status(HttpStatus.OK).body(this.handler.handler(command));
        } catch(NotFoundRestaurantException restaurantException) {
            return ResponseEntity.notFound().build();
        } catch (NotFoundKitchenExeception kitchenExeception) {
            return ResponseEntity.badRequest().body(kitchenExeception.getMessage());
        }
    }

    @PatchMapping(value = "/{restaurantId}")
    public ResponseEntity<?> invokePartial(@PathVariable Long restaurantId,
                                           @RequestBody Map<String, Object> properties) {
        try{
            UpdateRestaurantCommand command = new UpdateRestaurantCommand(restaurantId, properties);
            return ResponseEntity.status(HttpStatus.OK).body(this.handler.handler(command));
        } catch(NotFoundRestaurantException restaurantException) {
            return ResponseEntity.notFound().build();
        } catch (NotFoundKitchenExeception kitchenExeception) {
            return ResponseEntity.badRequest().body(kitchenExeception.getMessage());
        }
    }
}
