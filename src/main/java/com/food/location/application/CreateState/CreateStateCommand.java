package com.food.location.application.CreateState;

import lombok.Getter;

public class CreateStateCommand {

    @Getter
    private final String name;

    @Getter
    private final String uf;

    public CreateStateCommand(String name, String uf)
    {
        this.name = name;
        this.uf = uf;
    }
}
