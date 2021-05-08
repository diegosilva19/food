package com.food.location.presentation.controller;

import com.food.location.application.UpdateCity.UpdateCityCommand;
import com.food.location.application.UpdateCity.UpdateCityHandler;
import com.food.location.domain.entities.City;
import com.food.location.domain.exceptions.NotFoundCityException;
import com.food.location.domain.exceptions.NotFoundStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cities")
public class UpdateCityController {

    @Autowired
    private UpdateCityHandler handler;

    @PutMapping(value = "/{cityId}")
    public ResponseEntity<City> invoke(@RequestBody City city)
    {
        try{
            UpdateCityCommand command = new UpdateCityCommand(city);
            return ResponseEntity.status(HttpStatus.OK).body(this.handler.handle(command));
        }  catch (NotFoundCityException exeception) {
            return ResponseEntity.notFound().build();
        } catch (NotFoundStateException exeception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
