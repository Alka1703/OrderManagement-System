package com.order.Exception;

public class UserNotFoundException extends OrderManagementException {


	private static final long serialVersionUID = -1902507686064515121L;
	
	public UserNotFoundException() {
	
	}
	
	public UserNotFoundException(ExceptionMessage exceptionMessage) {
		super(exceptionMessage);
	}
	
	
	
}
