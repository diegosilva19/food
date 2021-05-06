package com.food.location.infrastructure.repositories.persistence;

import com.food.location.domain.StateRepository;
import com.food.location.domain.entities.State;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class StateRepositoryImpl implements StateRepository  {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public State searchById(Short id) {
        return this.manager.find(State.class, id);
    }

    @Override
    public List<State> list() {
        TypedQuery<State> cities = this.manager.createQuery("from State", State.class);
        return cities.getResultList();
    }

    @Override
    @Transactional
    public State save(State city) {
        return this.manager.merge(city);
    }

    @Override
    @Transactional
    public void delete(State state) {
        this.manager.remove(this.searchById(state.getId()));
    }
}
