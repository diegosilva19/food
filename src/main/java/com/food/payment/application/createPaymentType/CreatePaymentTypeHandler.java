package com.food.payment.application.createPaymentType;

import com.food.payment.domain.PaymentTypeRepository;
import com.food.payment.domain.entity.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CreatePaymentTypeHandler {

    @Autowired
    private PaymentTypeRepository repository;

    public PaymentType handle(CreatePaymentTypeCommand command)
    {
        PaymentType item = new PaymentType();
        item.setName(command.getPaymentTypeName());
        return this.repository.save(item);
    }
}
