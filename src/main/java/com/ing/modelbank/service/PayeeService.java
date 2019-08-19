package com.ing.modelbank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.Response.PayeeResponse;
import com.ing.modelbank.entity.Payee;
import com.ing.modelbank.repository.PayeeRepository;
@Service
public class PayeeService {
@Autowired
PayeeRepository payeeRepository;
	public PayeeResponse update(int payeeId, String payeeName, String payeeAccountType) {
		Optional<Payee> payee=payeeRepository.findBypayeeId(payeeId);
		
		if (payee.isPresent()) {
		 payeeRepository.update(payeeId,payeeName,payeeAccountType);

			PayeeResponse payeeResponse = new PayeeResponse();

			payeeResponse.setStatusCode(200);
			payeeResponse.setStatusMessage("ok");
			payeeResponse.setMessage("success");
			return payeeResponse;

		}

		else {
			PayeeResponse payeeResponse = new PayeeResponse();

			payeeResponse.setStatusCode(200);
			payeeResponse.setStatusMessage("ok");
			payeeResponse.setMessage("failure");
			return payeeResponse;
		}
	}


	public PayeeResponse updatePayee(int payeeId) {
		int accountNumber=0;
		Optional<Payee> payee = payeeRepository.findBypayeeId(payeeId);

		if (payee.isPresent()) {
		
			payeeRepository.updatePayee(payeeId,accountNumber);
			PayeeResponse payeeResponse = new PayeeResponse();

			payeeResponse.setStatusCode(200);
			payeeResponse.setStatusMessage("ok");
			payeeResponse.setMessage("success");
			return payeeResponse;

		}

		else {
			PayeeResponse payeeResponse = new PayeeResponse();

			payeeResponse.setStatusCode(200);
			payeeResponse.setStatusMessage("ok");
			payeeResponse.setMessage("failure");
			return payeeResponse;
		}
		
		
	}
}