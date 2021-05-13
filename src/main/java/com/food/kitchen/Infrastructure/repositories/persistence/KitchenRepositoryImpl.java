package com.food.kitchen.Infrastructure.repositories.persistence;

import com.food.kitchen.domain.entity.Kitchen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
class KitchenRepositoryImpl {

    @PersistenceContext
    private EntityManager manager;

    public List<Kitchen> list()
    {
        //JPQL -- executar queries em cima dos objetos e não tabelas
        TypedQuery<Kitchen> query = this.manager.createQuery("from Kitchen", Kitchen.class);
        return query.getResultList();
    }

    public List<Kitchen> searchByName(String name)
    {
        return manager.createQuery("from Kitchen where name LIKE :name", Kitchen.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    public Kitchen search(Long id)
    {
        return this.manager.find(Kitchen.class, id);
    }

    @Transactional
    public Kitchen save(Kitchen item)
    {
        return this.manager.merge(item);
    }

    @Transactional
    public void delete(Kitchen kitchen)
    {
        this.manager.remove(kitchen);
    }

    @Transactional
    public void delete(Long kitchenId)
    {
        /**
         * Fazer search do lado de fora e mandar aqui não adianta,
         * acreditoq ue é devido a anotação transactional que precisa existir
         * para ter o estado "manager" do JPA aonde é possível provocar a deleção
         */
        this.manager.remove(search(kitchenId));
    }
}
