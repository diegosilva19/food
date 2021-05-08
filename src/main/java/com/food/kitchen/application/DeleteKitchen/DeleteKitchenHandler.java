package com.food.kitchen.application.DeleteKitchen;

import com.food.kitchen.domain.KitchenRepository;
import com.food.kitchen.domain.entity.Kitchen;
import com.food.kitchen.domain.exceptions.KitchenInUseExeception;
import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class DeleteKitchenHandler {

    @Autowired
    private KitchenRepository repository;

    public boolean handle(DeleteKitchenCommand command) throws NotFoundKitchenExeception, KitchenInUseExeception {
        Kitchen kitchen = this.repository.search(command.getKitchenId());

        if (kitchen == null) {
            throw new NotFoundKitchenExeception();
        }

        try {
            this.repository.delete(kitchen);
        } catch(DataIntegrityViolationException exception) {
            //foreign key integrity
            throw new KitchenInUseExeception();
        }


        return true;
    }
}
