package com.food.location.application.listStates;

import com.food.location.domain.StateRepository;
import com.food.location.domain.entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListStatesHandler {

    @Autowired
    private StateRepository repository;
    
    public List<State> handle()
    {
        return this.repository.list();
    }
}
