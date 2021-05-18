package com.food.restaurant.infrastructure.repositories.persistence;

import com.food.restaurant.domain.RestaurantRepositoryQueries;
import com.food.restaurant.domain.entity.Restaurant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurant> find(String name, BigDecimal taxAmountInit, BigDecimal taxAmountEnd) {

        Query query = this.manager.createNativeQuery("select id, name, taxa_frete from restaurant");
        List<Object[]> genericResult = query.getResultList();

        for(Object[] record : genericResult) {

            Long id = Long.parseLong(String.valueOf(record[0]));
            String nameRestaurant = (String) record[1];
            BigDecimal taxaFrete = (BigDecimal) record[2];

            StringBuilder builder = new StringBuilder("Restaurant Id: " + id );
            builder.append("\nRestaurant name: " + nameRestaurant);
            builder.append(String.format("\nWith Tax Value: %.2f ", taxaFrete));

            System.out.println(builder.toString());
        }

        return null;
    }

    @Override
    public List<Restaurant> findByQueryBuilder(String name, BigDecimal taxAmountInit, BigDecimal taxAmountEnd) {

        String querySentence = "from Restaurant where name like :name and taxa_frete >= :taxInit and ";
        Query query = this.manager.createQuery(querySentence, Restaurant.class);
        query.setParameter(":name", "%" + name);
        query.setParameter(":name", "%" + name);


        return null;
    }
}
