package com.food;

import com.food.restaurant.domain.RestaurantRepository;
import com.food.restaurant.domain.entity.Restaurant;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

/**
 * toda necessidade de pegar um Application context , deve ser feito na raiz da aplicação,  por que o
 * spring só lê os pacotes do nível mais alto para o mais baixo logo
 *
 * com.food.teste  ( Command)
 * não consegue rodar o
 * com .food.application , por que na hora de buscar um "Bean" o mesmo não estará carregado
 *     https://pt.stackoverflow.com/questions/401093/no-qualifying-bean-of-type-ajuda-com-esse-error
 */
public class SearchRestaurantApplicationCommand {

    public static void main(String[] args) {

        ApplicationContext application = new SpringApplicationBuilder(FoodApplication.class)
                                            .web(WebApplicationType.NONE)
                                            .run(args);

        RestaurantRepository handler = application.getBean(RestaurantRepository.class);
        handler.findById(2L).ifPresent(
                restaurant -> {
                    System.out.printf("%s - %f - %s", restaurant.getName(),
                            restaurant.getFeeTransportTaxe(), restaurant.getKitchen().getName());
                }
        );
        // OR
        /*
        handler.findById(2L).ifPresent(
              SearchRestaurantApplicationCommand::printInformation
        );

         */
    }

    public static void printInformation(Restaurant restaurant)
    {
        System.out.printf("%s - %f - %s", restaurant.getName(),
                restaurant.getFeeTransportTaxe(), restaurant.getKitchen().getName());
    }
}
