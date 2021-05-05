package com.food.permission.application.create;

import com.food.permission.domain.Permission;
import com.food.permission.domain.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePermissionHandler {

    @Autowired
    private PermissionRepository repository;

    public Permission handle(CreatePermissionCommand command)
    {
        Permission permission = new Permission();
        permission.setDescription(command.getDescription());
        permission.setName(command.getName());
        permission = this.repository.save(permission);
        return permission;
    }
}
