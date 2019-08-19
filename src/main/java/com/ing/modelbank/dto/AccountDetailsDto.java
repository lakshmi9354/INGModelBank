
package com.ing.modelbank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDetailsDto {
	private Integer accountId;
	private String name;
	private String mobileNo;
	private String email;
	private Integer accountNumber;
	private double balance;
	private String accountType;
	private String message;
}