package com.ing.modelbank.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto implements Serializable{

	private static final long serialVersionUID = -7689164648992140575L;

	private String name;
	private String mobileNo;
	private String email;
	private String password;
	private String city;
	private String accountType;
}
