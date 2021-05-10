package com.food.restaurant.application.UpdateRestaurant;

import com.food.kitchen.application.FindKitchenById.FindKitchenByIdHandler;
import com.food.kitchen.domain.entity.Kitchen;
import com.food.kitchen.domain.exceptions.NotFoundKitchenExeception;
import com.food.restaurant.domain.RestaurantRepository;
import com.food.restaurant.domain.entity.Restaurant;
import com.food.restaurant.domain.event.UpdatedRestaurantEvent;
import com.food.restaurant.domain.exception.NotFoundRestaurantException;
import com.food.shared.domain.application.mergeHttpPatchObjects.mergePatialObjectWithMap;
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

    private Restaurant restauranOrigin ;

    private Restaurant restauranDatabase ;

    public Restaurant handler(UpdateRestaurantCommand command)
    {
        this.restauranOrigin = command.getRestaurant();
        this.restauranDatabase = this.repository.searchById(this.restauranOrigin.getId());

        if (this.restauranDatabase == null) {
            throw new NotFoundRestaurantException(this.restauranOrigin.getId());
        }

        this.updateFieldsDatabaseResultSet(command);

        this.restauranOrigin = this.repository.save(this.restauranDatabase);

        eventPublisher.publishEvent(new UpdatedRestaurantEvent(this.restauranOrigin));

        return this.restauranOrigin;
    }

    /**
     * Merge fields from Map<String, Object> (PATCH) or Restaurant -> Restaurant (PUT)
     *
     * Patch: needs merge values on database resultset fields and to response correctly  fetchKitchen received
     * Put: fetchKitchen ( originl obejct was passed no payload) and merge Original Object and Database
     *
     * @param command
     * @return
     */
    private void updateFieldsDatabaseResultSet(UpdateRestaurantCommand command)
    {
        if (command.getPartialFields() != null) {

            mergePatialObjectWithMap<Restaurant> parser = new mergePatialObjectWithMap<>(
                    command.getPartialFields(), this.restauranDatabase
            );
            this.restauranDatabase = parser.handle();
            this.fetchKitchen(this.restauranDatabase);

        } else {
            this.fetchKitchen(this.restauranOrigin);
            BeanUtils.copyProperties(this.restauranOrigin, this.restauranDatabase);
        }
    }

    private void fetchKitchen(Restaurant restaurant )
    {
        Kitchen kitchen = restaurant.getKitchen();

        if (kitchen != null && kitchen.getId() != null) {
            kitchen = this.kitchenFinder.handler(kitchen.getId());

            if (kitchen == null) {
                throw new NotFoundKitchenExeception();
            }

            restaurant.setKitchen(kitchen);
        }

        this.restauranOrigin = restaurant;
    }
}
