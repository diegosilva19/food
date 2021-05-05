package com.food.kitchen.Infrastructure.repositories.persistence;


import com.food.kitchen.domain.KitchenRepository;
import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Kitchen> list()
    {
        //JPQL -- executar queries em cima dos objetos e não tabelas
        TypedQuery<Kitchen> query = this.manager.createQuery("from Kitchen", Kitchen.class);
        return query.getResultList();
    }

    @Override
    public Kitchen search(Long id)
    {
        return this.manager.find(Kitchen.class, id);
    }

    @Transactional
    @Override
    public Kitchen save(Kitchen item)
    {
        return this.manager.merge(item);
    }

    @Transactional
    @Override
    public void delete(Kitchen kitchen)
    {
        /**
         * Fazer search do lado de fora e mandar aqui não adianta,
         * acreditoq ue é devido a anotação transactional que precisa existir
         * para ter o estado "manager" do JPA aonde é possível provocar a deleção
         */
        this.manager.remove(search(kitchen.getId()));
    }
}
