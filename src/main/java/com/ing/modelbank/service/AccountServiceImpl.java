package com.ing.modelbank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.controller.AccountController;
import com.ing.modelbank.dto.AccountDetailsDto;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.repository.AccountRepository;
import com.ing.modelbank.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public AccountDetailsDto getAccountSummary(Integer accountId) {
		AccountDetailsDto accountDetailsDto = null;
		Account account = accountRepository.findByAccountId(accountId);
		System.out.println("Customer Id: " + account.getCustomer().getCustomerId());
		Customer customer = customerRepository.findByCustomerId(account.getCustomer().getCustomerId());

		LOGGER.info("accont fetched...");
		accountDetailsDto = new AccountDetailsDto();
		accountDetailsDto.setAccountNumber(account.getAccountNumber());
		accountDetailsDto.setAccountType(account.getAccountType());
		accountDetailsDto.setBalance(account.getBalance());
		accountDetailsDto.setEmail(customer.getEmail());
		accountDetailsDto.setMobileNo(customer.getMobileNo());
		accountDetailsDto.setName(customer.getName());
		return accountDetailsDto;

	}

}
