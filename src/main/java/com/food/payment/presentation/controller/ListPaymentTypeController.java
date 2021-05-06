package com.food.payment.presentation.controller;


import com.food.payment.application.listPaymentTypeHandler.ListPaymentTypeHandler;
import com.food.payment.domain.entity.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/payment-type")
public class ListPaymentTypeController {

    @Autowired
    private ListPaymentTypeHandler handler;

    @GetMapping(value = "/list")
    @ResponseBody
    public List<PaymentType> invoke()
    {
        return this.handler.handle();
    }
}
