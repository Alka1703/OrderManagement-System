package com.order.exception;

public class OrderNotFoundException extends OrderManagementException {

	
	private static final long serialVersionUID = 4174143153994349652L;

	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(ExceptionMessage exceptionMessage) {
		super(exceptionMessage);
	}
}
