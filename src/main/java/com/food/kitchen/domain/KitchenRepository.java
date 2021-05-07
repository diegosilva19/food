package com.food.kitchen.domain;

import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KitchenRepository {

    public List<Kitchen> list();

    public Kitchen search(Long id);

    public Kitchen save(Kitchen item);

    void delete(Kitchen kitchen);

    void delete(Long kitchenId);
}

