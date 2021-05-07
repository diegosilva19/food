package com.food.kitchen.presentation.controller;

import com.food.kitchen.application.ListKitchens.ListKitchensHandler;
import com.food.kitchen.domain.entity.Kitchen;
import com.food.kitchen.presentation.response.ListKitchensXmlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/kitchens")
public class ListKitchensController {

    @Autowired
    private final ListKitchensHandler handler;

    public ListKitchensController(ListKitchensHandler handler) {
        this.handler = handler;
    }

    @GetMapping(path = "/list", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Kitchen> invoke() {
        return this.handler.handler();
    }

    @GetMapping(path = "/list", produces = {MediaType.APPLICATION_XML_VALUE})
    public ListKitchensXmlResponse invokeXmlList() {
        return new ListKitchensXmlResponse(this.handler.handler());
    }
}
