package com.food.restaurant.application.CreateRestaurant;

import com.food.kitchen.application.FindKitchenById.FindKitchenByIdHandler;
import com.food.kitchen.domain.entity.Kitchen;
import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import com.food.restaurant.domain.entity.Restaurant;
import com.food.restaurant.domain.event.CreateRestaurantEvent;
import com.food.restaurant.domain.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateRestaurantHandler {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private FindKitchenByIdHandler kitchenFinder;

    public Restaurant handler(CreateRestaurantCommand command)
    {
        Restaurant restaurant = command.getRestaurant();
        if (restaurant == null) {
            restaurant = new Restaurant();
            restaurant.setName(command.getName());
            restaurant.setFeeTransportTaxe(command.getFeeTransportTaxe());
        }

        restaurant = this.fetchKitchen(restaurant);
        restaurant = this.repository.save(restaurant);

        eventPublisher.publishEvent(new CreateRestaurantEvent(restaurant));

        return restaurant;
    }

    private Restaurant fetchKitchen(Restaurant restaurant )
    {
        Kitchen kitchen = restaurant.getKitchen();

        if (kitchen != null && kitchen.getId() != null) {
            Kitchen kitchenSearch = this.kitchenFinder.handler(kitchen.getId())
                    .orElseThrow(() -> new NotFoundKitchenExeception(kitchen.getId()));
            restaurant.setKitchen(kitchenSearch);
        }

        return restaurant;
    }
}
