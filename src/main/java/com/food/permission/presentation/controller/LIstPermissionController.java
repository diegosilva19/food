package com.food.permission.presentation.controller;

import com.food.permission.application.listPermissions.ListPermissionsHandler;
import com.food.permission.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/permissions")
public class LIstPermissionController {

    @Autowired
    private ListPermissionsHandler handler;

    @GetMapping(value = "/list")
    public List<Permission> invoke() {
        return this.handler.handle();
    }
}
