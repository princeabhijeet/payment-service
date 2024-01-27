package com.prince.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prince.paymentservice.dtos.PaymentDto;
import com.prince.paymentservice.entities.Payment;
import com.prince.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/payment")
	public ResponseEntity<Payment> doPayment(@RequestBody PaymentDto paymentDto) {
		Payment payment = paymentService.doPayment(paymentDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(payment);
	}
	
	@GetMapping("/payment/{orderId}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long orderId) {
		Payment payment = paymentService.getPayment(orderId);
		return ResponseEntity.status(HttpStatus.OK).body(payment);
	}

}
