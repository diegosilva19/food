package com.food.location.domain;

import com.food.location.domain.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface CityRepository extends JpaRepository<City, Short> {

}
