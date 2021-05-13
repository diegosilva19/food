package com.food.kitchen.application.UpdateKitchen;

import com.food.kitchen.domain.KitchenRepository;
import com.food.kitchen.domain.entity.Kitchen;
import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateKitchenHandler {

    @Autowired
    private KitchenRepository repository;

    public Kitchen handle(UpdateKitchenCommand updateCommand) throws NotFoundKitchenExeception {
        Kitchen kitchen = this.repository.findById(updateCommand.getKitchen().getId())
                                            .orElseThrow(NotFoundKitchenExeception::new);

        //mesma coisa que fazer set de propriedade a propriedade, ( tereiro parametro ignora propriedades X , Y , Z)
        BeanUtils.copyProperties(updateCommand.getKitchen(), kitchen);

        return this.repository.save(kitchen);
    }
}
