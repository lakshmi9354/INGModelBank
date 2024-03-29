package com.ing.modelbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.Response.AccountResponse;
import com.ing.modelbank.Response.PayeeResponse;


import com.ing.modelbank.service.PayeeService;
import com.ing.modelbank.service.TransactionService;

@RestController
public class PayeeController {
	@Autowired
	PayeeService payeeService;
	@Autowired
	TransactionService transactionService;

	@PutMapping("/updatePayee/{payeeId}/{payeeName}/{payeeAccountType}")
	public PayeeResponse update(@PathVariable int payeeId, @PathVariable String payeeName,
			@PathVariable String payeeAccountType)  {
		PayeeResponse payeeResponse = payeeService.update(payeeId, payeeName, payeeAccountType);
return payeeResponse;
		

	}

	@PutMapping("/deletePayee/{payeeId}")
	public PayeeResponse delete(@PathVariable int payeeId) {
		PayeeResponse payeeResponse =payeeService.updatePayee(payeeId);
		return payeeResponse;

	}
	@GetMapping("/transactions{accountNumber}")
	public AccountResponse display(@PathVariable int accountNumber)
	{
		AccountResponse response = transactionService.findByaccountNumber(accountNumber);
		

return response;
	}

@Autowired
	PayeeServiceImpl payeeServiceImpl;
	
	@PostMapping("/payee")
	public ResponseEntity<ResponseDto> addPayee(@RequestBody PayeeListDto payee)
	{
		return new ResponseEntity<ResponseDto>(payeeServiceImpl.addPayee(payee),HttpStatus.OK);
	}
	
	@GetMapping("/otpVerification/{otpNo}")
	public ResponseEntity<ResponseDto> verifyOtp(@PathVariable("otpNo") int otpNo)
	{
		return new ResponseEntity<ResponseDto>(payeeServiceImpl.verifyDto(otpNo),HttpStatus.OK);
	}

	@GetMapping("/payees/{accountId}")
	public ResponseEntity<List<PayeeDetailsDto>> payees(Integer accountId){
		return new ResponseEntity<List<PayeeDetailsDto>>(payeeServiceImpl.payees(accountId),HttpStatus.OK);
	}
}
