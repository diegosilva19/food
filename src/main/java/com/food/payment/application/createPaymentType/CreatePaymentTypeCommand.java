package com.food.payment.application.createPaymentType;

import lombok.Getter;

public class CreatePaymentTypeCommand {

    @Getter
    private String paymentTypeName;

    public CreatePaymentTypeCommand(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }
}
