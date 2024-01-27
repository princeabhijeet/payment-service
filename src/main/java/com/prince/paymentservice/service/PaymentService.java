package com.prince.paymentservice.service;

import com.prince.paymentservice.dtos.PaymentDto;
import com.prince.paymentservice.entities.Payment;

public interface PaymentService {
	Payment doPayment(PaymentDto paymentDto);
	Payment getPayment(Long orderId);
}
