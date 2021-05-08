package com.food.restaurant.application.UpdateRestaurant;

import com.food.kitchen.application.FindKitchenById.FindKitchenByIdHandler;
import com.food.kitchen.domain.entity.Kitchen;
import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import com.food.restaurant.domain.RestaurantRepository;
import com.food.restaurant.domain.entity.Restaurant;
import com.food.restaurant.domain.event.UpdatedRestaurantEvent;
import com.food.restaurant.domain.exception.NotFoundRestaurantException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UpdateRestaurantHandler {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private FindKitchenByIdHandler kitchenFinder;

    public Restaurant handler(UpdateRestaurantCommand command)
    {
        Restaurant restaurant = command.getRestaurant();
        Restaurant restaurantDatabase = this.repository.searchById(restaurant.getId());

        if (restaurantDatabase == null) {
            throw new NotFoundRestaurantException(restaurant.getId());
        }
        restaurant = this.fetchKitchen(restaurant);

        BeanUtils.copyProperties(restaurant, restaurantDatabase);

        restaurant = this.repository.save(restaurantDatabase);

        eventPublisher.publishEvent(new UpdatedRestaurantEvent(restaurant));

        return restaurant;
    }

    private Restaurant fetchKitchen(Restaurant restaurant )
    {
        Kitchen kitchen = restaurant.getKitchen();

        if (kitchen != null && kitchen.getId() != null) {
            kitchen = this.kitchenFinder.handler(kitchen.getId());
        }

        if (kitchen == null) {
            throw new NotFoundKitchenExeception();
        }
        restaurant.setKitchen(kitchen);
        return restaurant;
    }
}
