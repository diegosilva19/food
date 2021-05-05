package com.food.permission.infrastructure.repositories.persistence;

import com.food.permission.domain.Permission;
import com.food.permission.domain.PermissionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class PermissionRepositoryImpl implements PermissionRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Permission find(int id) {
        return this.manager.find(Permission.class, id);
    }

    @Override
    public List<Permission> list() {
        TypedQuery<Permission> permissions =  this.manager.createQuery("from Permission", Permission.class);
        return permissions.getResultList();
    }

    @Override
    @Transactional
    public Permission save(Permission permission) {
        return this.manager.merge(permission);
    }

    @Override
    @Transactional
    public void delete(Permission permission) {
        this.delete(permission.getId());
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.manager.remove(this.find(id));
    }
}
