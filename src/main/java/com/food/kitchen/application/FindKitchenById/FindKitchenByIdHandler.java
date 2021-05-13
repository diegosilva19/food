package com.food.kitchen.application.FindKitchenById;

import com.food.kitchen.domain.KitchenRepository;
import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindKitchenByIdHandler {

    @Autowired
    private KitchenRepository repository;

    public Optional<Kitchen> handler(FindKitchenByIdQuery finder)
    {
        return this.repository.findById(finder.getKitchenId());
    }

    public Optional<Kitchen> handler(Long kitchenId) {
        return this.repository.findById(kitchenId);
    }
}
