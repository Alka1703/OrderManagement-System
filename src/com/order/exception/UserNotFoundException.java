package com.order.exception;

public class UserNotFoundException extends OrderManagementException {

	private static final long serialVersionUID = -8726563052769816274L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(ExceptionMessage exceptionMessage) {
		super(exceptionMessage);
	}
}
