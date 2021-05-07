package com.food.kitchen.application.FindKitchenById;

import com.food.kitchen.domain.KitchenRepository;
import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindKitchenByIdHandler {

    @Autowired
    private KitchenRepository repository;

    public Kitchen handler(FindKitchenByIdQuery finder)
    {
        return this.repository.search(finder.getKitchenId());
    }
}
