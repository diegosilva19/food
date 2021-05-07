package com.food.payment.presentation.controller;


import com.food.payment.application.listPaymentTypeHandler.ListPaymentTypeHandler;
import com.food.payment.domain.entity.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/payment-type")
public class ListPaymentTypeController {

    @Autowired
    private ListPaymentTypeHandler handler;

    @GetMapping(value = "/list")
    public List<PaymentType> invoke()
    {
        return this.handler.handle();
    }
}
