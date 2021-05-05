package com.food;

import com.food.kitchen.domain.KitchenRepository;
import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * toda necessidade de pegar um Application context , deve ser feito na raiz da aplicação,  por que o
 * spring só lê os pacotes do nível mais alto para o mais baixo logo
 *
 * com.food.teste  ( Command)
 * não consegue rodar o
 * com .food.application , por que na hora de buscar um "Bean" o mesmo não estará carregado
 *     https://pt.stackoverflow.com/questions/401093/no-qualifying-bean-of-type-ajuda-com-esse-error
 */
public class ListKitchensApplicationCommand {

    public static void main(String[] args) {

        ApplicationContext application = new SpringApplicationBuilder(FoodApplication.class)
                                            .web(WebApplicationType.NONE)
                                            .run(args);

        KitchenRepository handler = application.getBean(KitchenRepository.class);
        List<Kitchen> listagem = handler.list();

        for(Kitchen item : listagem) {
            System.out.println("Mostrnado item via Command Line -> " + item.getName());
        }
    }
}
