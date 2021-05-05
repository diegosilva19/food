package com.food.restaurant.infrastructure.repositories.persistence;

import com.food.kitchen.domain.entity.Kitchen;
import com.food.restaurant.domain.RestaurantRepository;
import com.food.restaurant.domain.entity.Restaurant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurant> list() {
        //JPQL -- executar queries em cima dos objetos e não tabelas
        TypedQuery<Restaurant> query = this.manager.createQuery("from Restaurant", Restaurant.class);
        return query.getResultList();
    }

    @Override
    public Restaurant searchById(Long id) {
        return manager.find(Restaurant.class, id);
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant item) {
        return manager.merge(item);
    }

    @Override
    @Transactional
    public void delete(Restaurant item) {
        manager.remove(searchById(item.getId()));
    }
}
