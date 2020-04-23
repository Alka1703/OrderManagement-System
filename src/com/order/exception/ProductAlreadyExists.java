package com.order.Exception;

public class ProductAlreadyExists extends OrderManagementException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 56089803682174230L;
	public ProductAlreadyExists() {
	
	}
	public ProductAlreadyExists(ExceptionMessage exceptionMessage)
	{
		super(exceptionMessage);
	}

}
