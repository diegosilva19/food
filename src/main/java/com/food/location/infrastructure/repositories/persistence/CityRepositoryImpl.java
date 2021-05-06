package com.food.location.infrastructure.repositories.persistence;

import com.food.location.domain.CityRepository;
import com.food.location.domain.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public City searchById(Short id) {
        return this.manager.find(City.class, id);
    }

    @Override
    public List<City> list() {
        TypedQuery<City> cities = this.manager.createQuery("from City", City.class);
        return cities.getResultList();
    }

    @Override
    @Transactional
    public City save(City city) {
        return this.manager.merge(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        this.manager.remove(this.searchById(city.getId()));
    }
}
