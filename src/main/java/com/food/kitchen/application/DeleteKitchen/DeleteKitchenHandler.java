package com.food.kitchen.application.DeleteKitchen;

import com.food.kitchen.domain.KitchenRepository;
import com.food.kitchen.domain.exceptions.KitchenInUseExeception;
import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DeleteKitchenHandler {

    @Autowired
    private KitchenRepository repository;

    public boolean handle(DeleteKitchenCommand command) throws NotFoundKitchenExeception, KitchenInUseExeception {
        try {
            this.repository.deleteById(command.getKitchenId());
        } catch(DataIntegrityViolationException exception) {
            //foreign key integrity
            throw new KitchenInUseExeception();
        } catch (EmptyResultDataAccessException exception) {
            throw new NotFoundKitchenExeception();
        }
        return true;
    }
}
