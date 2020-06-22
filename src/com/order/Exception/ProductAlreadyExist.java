package com.order.Exception;

public class ProductAlreadyExist extends OrderManagementException {


	private static final long serialVersionUID = -613978130914804135L;
	
	
	public ProductAlreadyExist() {
	
	}
	public ProductAlreadyExist(ExceptionMessage exceptionMessage)
	{
		super(exceptionMessage);
	}

}
