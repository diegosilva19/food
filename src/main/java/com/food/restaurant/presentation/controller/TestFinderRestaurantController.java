package com.food.restaurant.presentation.controller;

import com.food.restaurant.application.FindRestaurantById.FindRestaurantByIdQuery;
import com.food.restaurant.domain.RestaurantRepository;
import com.food.restaurant.domain.entity.Restaurant;
import com.food.restaurant.domain.exception.NotFoundRestaurantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/restaurants")
public class TestFinderRestaurantController {

    @Autowired
    private RestaurantRepository repository;

    @GetMapping("/find-by-name-and-kitchen-id")
    public ResponseEntity<List<Restaurant>> invoke(String restaurantName,  Long kitchenId) {

        try {
            List<Restaurant> restaurant = this.repository.searchByNameContainingAndKitchenId(restaurantName, kitchenId);
            return ResponseEntity.status(HttpStatus.OK).body(restaurant);
        } catch(NotFoundRestaurantException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search-name-kitchenId")
    public ResponseEntity<List<Restaurant>> searchnNamekitchenId(String restaurantName,  Long kitchenId) {
 
        try {
            List<Restaurant> restaurant = this.repository.searchByNameAndKitchenId(restaurantName, kitchenId);
            return ResponseEntity.status(HttpStatus.OK).body(restaurant);
        } catch(NotFoundRestaurantException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/custom-find")
    public ResponseEntity<List<Restaurant>> customFind(String restaurantName,
                                                       BigDecimal taxAmounInitial, BigDecimal taxAmounEnd) {

        try {
            List<Restaurant> restaurant = this.repository.find(restaurantName, taxAmounInitial, taxAmounEnd );
            return ResponseEntity.status(HttpStatus.OK).body(restaurant);
        } catch(NotFoundRestaurantException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
