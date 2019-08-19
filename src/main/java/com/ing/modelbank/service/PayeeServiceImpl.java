package com.ing.modelbank.service;

import java.util.List;

import com.ing.modelbank.config.dto.PayeeDetailsDto;
import com.ing.modelbank.config.dto.PayeeListDto;
import com.ing.modelbank.config.dto.ResponseDto;

public interface PayeeServiceImpl {

	public ResponseDto addPayee(PayeeListDto payee);
	
	public ResponseDto verifyDto(int otpNo);
	
	public List<PayeeDetailsDto> payees(Integer accountId);
}
