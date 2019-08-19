package com.ing.modelbank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
	private String message;
	private Integer accountId;
	private String status;
}
