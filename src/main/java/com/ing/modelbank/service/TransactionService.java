package com.ing.modelbank.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.Response.AccountResponse;
import com.ing.modelbank.entity.Transaction;
import com.ing.modelbank.repository.TransactionRepository;
@Service
public class TransactionService {
@Autowired
TransactionRepository transactionRepository;
	public  AccountResponse findByaccountNumber(int accountNumber) {
		List<Transaction> transaction = transactionRepository.findByaccountNumber(accountNumber);
		if (transaction.isEmpty()) {
		
			AccountResponse accountResponse = new AccountResponse();
			accountResponse.setStatusCode(200);
					accountResponse.setStatusMessage("ok");
					accountResponse.setMessage("failure");
					return accountResponse;
		

		}

		else {
			
			AccountResponse accountResponse = new AccountResponse();
			accountResponse.setTransaction(transaction);
			accountResponse.setStatusCode(200);
			accountResponse.setStatusMessage("ok");
			accountResponse.setMessage("success");
			return accountResponse;	
	
		}

	}

}
