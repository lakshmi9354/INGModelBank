package com.ing.modelbank.config.dto;

import java.io.Serializable;

public class PayeeDetailsDto implements Serializable{

	private static final long serialVersionUID = 5239408827293030913L;

	private Integer accountNumber;

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
