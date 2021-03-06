package com.food.kitchen.domain;

import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Long> {

    List<Kitchen> searchByName(String nameSearch);

    List<Kitchen> findByname(String nameSearch);

    List<Kitchen> findBynameContaining(String nameSearch);
}

