package com.food.shared.domain.application.listenEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.food.restaurant.domain.event.CreateRestaurantEvent;

@Component
public class GenericEventListener {

    @EventListener
    public void notify(CreateRestaurantEvent event) {

        System.out.println("Restaurante Criado : " + event.toString());
    }
}

