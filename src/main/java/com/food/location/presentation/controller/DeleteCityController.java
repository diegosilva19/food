package com.food.location.presentation.controller;

import com.food.location.application.DeleteCity.DeleteCityCommand;
import com.food.location.application.DeleteCity.DeleteCityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(path = "/cities")
public class DeleteCityController {

    @Autowired
    private DeleteCityHandler handler;

    @DeleteMapping(value = "/{cityId}")
    public ResponseEntity<?> invoke(@PathVariable Short cityId)
    {
        try{
            DeleteCityCommand command = new DeleteCityCommand(cityId);
            this.handler.handle(command);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException exeception) {
            return ResponseEntity.notFound().build();
        }
    }
}
