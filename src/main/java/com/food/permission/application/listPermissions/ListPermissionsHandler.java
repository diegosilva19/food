package com.food.permission.application.listPermissions;

import com.food.permission.domain.Permission;
import com.food.permission.domain.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListPermissionsHandler {

    @Autowired
    private PermissionRepository repository;

    public List<Permission> handle()
    {
        return this.repository.list();
    }
}
