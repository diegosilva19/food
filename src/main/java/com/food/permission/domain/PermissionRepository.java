package com.food.permission.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionRepository {

    public Permission find(int id);

    public List<Permission> list();

    public Permission save(Permission permission);

    public void delete(Permission permission);

    public void delete(int id);

}
