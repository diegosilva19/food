package com.food.restaurant.domain;

import com.food.restaurant.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface RestaurantRepositoryQueries {

    List<Restaurant> find(String name, BigDecimal taxAmountInit, BigDecimal taxAmountEnd);

    List<Restaurant> findByQueryBuilder(String name, BigDecimal taxAmountInit, BigDecimal taxAmountEnd);
}
