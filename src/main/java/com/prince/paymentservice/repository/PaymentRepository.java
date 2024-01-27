package com.prince.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prince.paymentservice.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	Payment findByOrderId(Long orderId);
	
}
