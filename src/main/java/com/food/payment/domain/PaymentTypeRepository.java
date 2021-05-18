package com.food.payment.domain;

import com.food.payment.domain.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Short> {

   // public PaymentType search(Short id);

   // public PaymentType search(PaymentType paymentItem);
}
