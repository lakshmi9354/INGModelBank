package com.ing.modelbank.Response;


import java.util.List;

import com.ing.modelbank.entity.Transaction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString @NoArgsConstructor
public class AccountResponse {
	List<Transaction> transaction;
	private int statusCode;
	private String message;
	private String statusMessage;
}
