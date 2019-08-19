package com.ing.modelbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "otp")
public class Otp {
	
	@Id
	@GeneratedValue
	private int otpId;
	private int otpNo;
	private int customerId;
	public int getOtpId() {
		return otpId;
	}
	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}
	public int getOtpNo() {
		return otpNo;
	}
	public void setOtpNo(int otpNo) {
		this.otpNo = otpNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	

}
