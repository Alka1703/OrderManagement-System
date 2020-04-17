package com.order.exception;


public class OrderManagementException extends Exception{
	
private static final long serialVersionUID = 1666497646172567401L;
	
	private ExceptionMessage exceptionMessage;

	public OrderManagementException() {
		super();
	}

	public OrderManagementException(ExceptionMessage exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}

	public ExceptionMessage getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(ExceptionMessage exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
