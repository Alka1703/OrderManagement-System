package com.order.Exception;

public class UserAlreadyExist extends OrderManagementException {


	private static final long serialVersionUID = -613978130914804135L;
	
	
	public UserAlreadyExist() {
	
	}
	public UserAlreadyExist(ExceptionMessage exceptionMessage)
	{
		super(exceptionMessage);
	}

}
