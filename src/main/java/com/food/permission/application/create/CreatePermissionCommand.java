package com.food.permission.application.create;

public class CreatePermissionCommand {

    private final String description;

    private final String name;

    public CreatePermissionCommand(String description, String name)
    {
        this.description = description;
        this.name = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }
}
