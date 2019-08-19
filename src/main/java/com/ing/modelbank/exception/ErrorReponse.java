package com.ing.modelbank.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorReponse implements Serializable{

	private static final long serialVersionUID = 7528478436331293543L;
	
	private String message;
	private Integer statusCode;

}
