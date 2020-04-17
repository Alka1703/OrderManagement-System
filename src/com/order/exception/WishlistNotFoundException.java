package com.order.exception;

public class WishlistNotFoundException extends OrderManagementException {

	private static final long serialVersionUID = 4589921570248464728L;

	public WishlistNotFoundException() {
		super();
	}

	public WishlistNotFoundException(ExceptionMessage exceptionMessage) {
		super(exceptionMessage);
	}
	
	
}
