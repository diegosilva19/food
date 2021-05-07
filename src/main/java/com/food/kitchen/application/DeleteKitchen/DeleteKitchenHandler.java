package com.food.kitchen.application.DeleteKitchen;

import com.food.kitchen.domain.KitchenRepository;
import com.food.kitchen.domain.entity.Kitchen;
import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteKitchenHandler {

    @Autowired
    private KitchenRepository repository;

    public boolean handle(DeleteKitchenCommand command) throws NotFoundKitchenExeception
    {
        Kitchen kitchen = this.repository.search(command.getKitchenId());

        if (kitchen == null) {
            throw new NotFoundKitchenExeception();
        }

        this.repository.delete(kitchen);

        return true;
    }
}
