package com.prince.paymentservice.exception;

public class PaymentServiceCustomException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private String errorCode;
	
	public PaymentServiceCustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
