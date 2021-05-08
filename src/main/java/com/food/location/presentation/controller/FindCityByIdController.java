package com.food.location.presentation.controller;

import com.food.location.application.FindCityById.FindCityByIdHandler;
import com.food.location.application.FindCityById.FindCityByIdQuery;
import com.food.location.domain.entities.City;
import com.food.location.domain.exceptions.NotFoundCityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cities")
public class FindCityByIdController {

    @Autowired
    private FindCityByIdHandler handler;

    @GetMapping(value = "/{cityId}")
    public ResponseEntity<City> invoke(@PathVariable Short cityId)
    {
        try{
            FindCityByIdQuery command = new FindCityByIdQuery(cityId);
            return ResponseEntity.status(HttpStatus.OK).body(this.handler.handle(command));
        }  catch (NotFoundCityException exeception) {
            return ResponseEntity.notFound().build();
        }
    }
}
