package com.ing.modelbank.config.dto;

import lombok.Getter;
import lombok.Setter;

public class PayeeListDto {
	
	private int payeeId;
	private String payeeName;
	private int payeeAccountNumber;
	private int payeeMobileNo;
	private String payeeEmailId;
	private String payeeAccountType;
	private int accountId;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public int getPayeeAccountNumber() {
		return payeeAccountNumber;
	}
	public void setPayeeAccountNumber(int payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}
	public int getPayeeMobileNo() {
		return payeeMobileNo;
	}
	public void setPayeeMobileNo(int payeeMobileNo) {
		this.payeeMobileNo = payeeMobileNo;
	}
	public String getPayeeEmailId() {
		return payeeEmailId;
	}
	public void setPayeeEmailId(String payeeEmailId) {
		this.payeeEmailId = payeeEmailId;
	}
	public String getPayeeAccountType() {
		return payeeAccountType;
	}
	public void setPayeeAccountType(String payeeAccountType) {
		this.payeeAccountType = payeeAccountType;
	}	

}
