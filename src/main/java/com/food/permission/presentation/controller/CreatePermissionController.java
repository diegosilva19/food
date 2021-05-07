package com.food.permission.presentation.controller;

import com.food.permission.application.create.CreatePermissionHandler;
import com.food.permission.application.create.CreatePermissionCommand;
import com.food.permission.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/permissions")
public class CreatePermissionController {

    @Autowired
    private CreatePermissionHandler handler;

    @PostMapping(value = "/create")
    public Permission invoke(@RequestBody Map<String, Object> parameters) {

        // aprender como navegar em multi niveis de payload
        CreatePermissionCommand permissionCreator = new CreatePermissionCommand(
                (String) parameters.get("description"),
                (String) parameters.get("name")
       );

        return this.handler.handle(permissionCreator);
    }
}
