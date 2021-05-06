package com.food.location.domain;

import com.food.location.domain.entities.State;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StateRepository {

    public State searchById(Short id);

    public List<State> list();

    public State save(State city);

    void delete(State city);
}
