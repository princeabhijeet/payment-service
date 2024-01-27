package com.prince.paymentservice.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prince.paymentservice.dtos.PaymentDto;
import com.prince.paymentservice.entities.Payment;
import com.prince.paymentservice.exception.PaymentServiceCustomException;
import com.prince.paymentservice.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment doPayment(PaymentDto paymentDto) {
		Payment payment = Payment.builder()
				.orderId(paymentDto.getOrderId())
				.referenceNumber(UUID.randomUUID().toString())
				.totalAmount(paymentDto.getTotalAmount())
				.paymentStatus("SUCCESS")
				.paymentDate(Timestamp.from(Instant.now()))
				.build();
		Payment savedPayment = paymentRepository.save(payment);
		log.info("PaymentId {} successfully saved in database!", payment.getPaymentId());
		return savedPayment;
	}

	@Override
	public Payment getPayment(Long orderId) {
		
		Payment payment = paymentRepository.findByOrderId(orderId);
		
		if(null == payment) {
			log.error("Payment details not found for orderiD {}", orderId);
			throw new PaymentServiceCustomException("Payment details not found for orderId " + orderId, "PAYMENT_DETAILS_NOT_FOUND");
		}
		
		log.info("PaymentId {} found for orderId {} with paymentStatus {}", payment.getPaymentId(), orderId, payment.getPaymentStatus());
		return payment;
	}

}
