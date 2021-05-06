package com.food.payment.domain;

import com.food.payment.domain.entity.PaymentType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PaymentTypeRepository {

    public PaymentType search(Short id);

    public PaymentType search(PaymentType paymentItem);

    public List<PaymentType> list();

    public PaymentType save(PaymentType paymentItem);

    void delete(PaymentType paymentItem);
}
