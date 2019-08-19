package com.ing.modelbank.exception;

public class OtpException extends RuntimeException {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OtpException(String message) {
		super();
		this.message = message;
	}

}
