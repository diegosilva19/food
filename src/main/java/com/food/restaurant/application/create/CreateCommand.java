package com.food.restaurant.application.create;

import java.math.BigDecimal;

public class CreateCommand {

    private String name;

    private BigDecimal feeTransportTaxe;

    public CreateCommand(String name, BigDecimal feeTransportTaxe) {
        this.name = name;
        this.feeTransportTaxe = feeTransportTaxe;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getFeeTransportTaxe() {
        return feeTransportTaxe;
    }
}
