package com.food.kitchen.application.CreateKitchen;

import com.food.kitchen.domain.KitchenRepository;
import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateKitchenHandler {

    @Autowired
    private KitchenRepository repository;

    public Kitchen handle(CreateKitchenCommand command)
    {
        Kitchen kitchen = new Kitchen();
        kitchen.setName(command.getKitchenName());
        return this.repository.save(kitchen);
    }
}
