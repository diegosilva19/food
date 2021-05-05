package com.food.permission.presentation.controller;

import com.food.permission.application.create.CreatePermissionHandler;
import com.food.permission.application.create.CreatePermissionCommand;
import com.food.permission.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(path = "/permission")
public class CreatePermissionController {

    @Autowired
    private CreatePermissionHandler handler;

    @PostMapping(value = "/create")
    @ResponseBody
    public Permission invoke(@RequestBody Map<String, Object> parameters) {

        // aprender como navegar em multi niveis de payload
        CreatePermissionCommand permissionCreator = new CreatePermissionCommand(
                (String) parameters.get("description"),
                (String) parameters.get("name")
       );

        return this.handler.handle(permissionCreator);
    }
}
