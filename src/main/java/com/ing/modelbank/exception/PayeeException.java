package com.ing.modelbank.exception;

public class PayeeException extends RuntimeException {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PayeeException(String message) {
		super();
		this.message = message;
	}
}
