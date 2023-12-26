package com.losolved.payment.repositories;

import org.springframework.data.repository.CrudRepository;

import com.losolved.payment.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
