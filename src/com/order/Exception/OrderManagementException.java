package com.order.Exception;


public class OrderManagementException extends Exception {

	private static final long serialVersionUID = -3555867275540165828L;
	
	private ExceptionMessage exceptionMessage;
	
	public OrderManagementException() {
	
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
	
	@Override
	public synchronized Throwable fillInStackTrace() {
		//return super.fillInStackTrace();
		return this;
	}
	
	
	
	
}
