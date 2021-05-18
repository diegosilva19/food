package com.food.payment.application.listPaymentTypeHandler;

import com.food.payment.domain.PaymentTypeRepository;
import com.food.payment.domain.entity.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPaymentTypeHandler {

    @Autowired
    private PaymentTypeRepository repository;

    public List<PaymentType> handle()
    {
        return this.repository.findAll();
    }
}
