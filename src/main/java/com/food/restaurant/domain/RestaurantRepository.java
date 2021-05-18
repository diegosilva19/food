package com.food.restaurant.domain;

import com.food.restaurant.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, RestaurantRepositoryQueries {

    List<Restaurant> searchByNameContainingAndKitchenId(String name, Long kitchenId);

    @Query("from Restaurant where name like %:name and kitchen.id = :kitchenId")
    List<Restaurant> searchByNameAndKitchenId(String name, @Param("kitchenId") Long kitchenId);
}
