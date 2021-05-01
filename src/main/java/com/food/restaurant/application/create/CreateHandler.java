package com.food.restaurant.application.create;

import com.food.restaurant.persistence.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import com.food.restaurant.domain.entity.Restaurant;
import com.food.restaurant.domain.event.CreateRestaurantEvent;
import com.food.restaurant.presentation.CreateResponse;

import java.math.BigDecimal;

@Component
public class CreateHandler {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private final RestaurantRepository repository;

    public CreateHandler(RestaurantRepository repository) {
        this.repository = repository;
    }

    public CreateResponse handler() {

        System.out.println("Chamou aqui ");
        Restaurant restaurant = new Restaurant();
        restaurant.setNome("Castelo");
        restaurant.setTaxaFrete(new BigDecimal("10.25"));
        this.repository.save(restaurant);
        eventPublisher.publishEvent(new CreateRestaurantEvent(restaurant));
        return new CreateResponse(restaurant);
    }
}
