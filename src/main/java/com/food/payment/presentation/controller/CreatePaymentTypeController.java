package com.food.payment.presentation.controller;

import com.food.payment.application.createPaymentType.CreatePaymentTypeCommand;
import com.food.payment.application.createPaymentType.CreatePaymentTypeHandler;
import com.food.payment.domain.entity.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(path = "/payment-type")
public class CreatePaymentTypeController {

    @Autowired
    private CreatePaymentTypeHandler handler;

    @PostMapping(value = "/create")
    @ResponseBody
    public PaymentType invoke(@RequestBody Map<String, Object> parameters)
    {
        CreatePaymentTypeCommand command = new CreatePaymentTypeCommand((String) parameters.get("name"));
        return this.handler.handle(command);
    }
}
