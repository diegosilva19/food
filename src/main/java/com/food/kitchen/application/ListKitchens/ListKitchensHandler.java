package com.food.kitchen.application.ListKitchens;

import com.food.kitchen.domain.KitchenRepository;
import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ListKitchensHandler {

    @Autowired
    private KitchenRepository repository;

    public List<Kitchen> handler()
    {
        return this.repository.findAll();
    }
}
