package com.food.permission.presentation.controller;

import com.food.permission.application.listPermissions.ListPermissionsHandler;
import com.food.permission.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/permission")
public class LIstPermissionController {

    @Autowired
    private ListPermissionsHandler handler;

    @GetMapping(value = "/list")
    @ResponseBody
    public List<Permission> invoke() {
        return this.handler.handle();
    }
}
