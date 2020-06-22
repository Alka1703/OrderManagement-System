package com.order.Exception;

public class StockNotFoundException extends OrderManagementException{

	private static final long serialVersionUID = 6950599164321255199L;

	public StockNotFoundException() {
		super();
	}

	public StockNotFoundException(ExceptionMessage exceptionMessage) {
		super(exceptionMessage);
		
	}
	

}
