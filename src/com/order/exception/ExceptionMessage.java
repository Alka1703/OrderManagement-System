package com.order.exception;

public class ExceptionMessage{
	private String message;

	public ExceptionMessage() {
		super();
	}

	public ExceptionMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
