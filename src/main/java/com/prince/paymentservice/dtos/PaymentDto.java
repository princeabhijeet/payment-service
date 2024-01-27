package com.prince.paymentservice.dtos;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PaymentDto {
	private Long orderId;
	private Long totalAmount;
	private String paymentStatus;
	private Timestamp paymentDate;
}
