package com.food.kitchen.application.ListKitchens;

import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ListKitchensHandler {


    @PersistenceContext
    private EntityManager manager;

    public List<Kitchen> handler()
    {
        //JPQL -- executar queries em cima dos objetos e não tabelas
        TypedQuery<Kitchen> query = this.manager.createQuery("from Kitchen", Kitchen.class);
        return query.getResultList();
    }
}
