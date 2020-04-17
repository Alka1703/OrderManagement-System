package com.order.exception;

public class ProductNotFoundException extends OrderManagementException {

	
	private static final long serialVersionUID = -4490882794182328862L;

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(ExceptionMessage exceptionMessage) {
		super(exceptionMessage);
	}
}
