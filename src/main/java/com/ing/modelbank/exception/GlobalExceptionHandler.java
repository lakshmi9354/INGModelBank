package com.ing.modelbank.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PayeeException.class)
	public ResponseEntity<ErrorResponse> handlePayeeException(PayeeException exception)
	{
		ErrorResponse errorResponse = new ErrorResponse(new Date(), exception.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OtpException.class)
	public ResponseEntity<ErrorResponse> handleOtpException(OtpException exception)
	{
		ErrorResponse errorResponse = new ErrorResponse(new Date(), exception.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}

}
