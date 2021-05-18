package com.food.kitchen.presentation.controller;

import com.food.kitchen.domain.KitchenRepository;
import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/kitchens")
public class TestFindKitchensController {

    @Autowired
    private KitchenRepository repository;

    @GetMapping(path = "/find")
    public ResponseEntity<List<Kitchen>> invoke(@RequestParam("name") String nameSearch) {
        List<Kitchen>listKitchens = this.repository.findByname(nameSearch);
        return ResponseEntity.ok(listKitchens);
    }
}
