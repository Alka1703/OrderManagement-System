package com.order.Exception;

public class CategoryAlreadyExist extends OrderManagementException {

	private static final long serialVersionUID = -1988652141040720300L;
	
	public CategoryAlreadyExist() {
	
	}

	public CategoryAlreadyExist(ExceptionMessage exceptionMessage) {
		super(exceptionMessage);
	
	}

	

}
