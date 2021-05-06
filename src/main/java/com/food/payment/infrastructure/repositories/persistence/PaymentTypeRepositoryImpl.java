package com.food.payment.infrastructure.repositories.persistence;

import com.food.payment.domain.PaymentTypeRepository;
import com.food.payment.domain.entity.PaymentType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class PaymentTypeRepositoryImpl implements PaymentTypeRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public PaymentType search(Short id) {
        return this.manager.find(PaymentType.class, id);
    }

    @Override
    public PaymentType search(PaymentType paymentItem) {
        return this.search(paymentItem.getId());
    }

    @Override
    public List<PaymentType> list() {
        TypedQuery<PaymentType> items = this.manager.createQuery("from PaymentType", PaymentType.class);
        return items.getResultList();
    }

    @Override
    @Transactional
    public PaymentType save(PaymentType paymentItem) {
        return this.manager.merge(paymentItem);
    }

    @Override
    @Transactional
    public void delete(PaymentType paymentItem) {
        this.manager.remove(this.search(paymentItem.getId()));
    }
}
