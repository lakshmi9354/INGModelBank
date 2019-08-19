package com.ing.modelbank.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.dto.CustomerDetailsDto;
import com.ing.modelbank.dto.CustomerDto;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.exception.EmailException;
import com.ing.modelbank.repository.AccountRepository;
import com.ing.modelbank.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountRepository accountRepository;
	Random random = new Random();

	@Override
	public CustomerDetailsDto register(CustomerDto customerDto) {
		LOGGER.debug("CustomerServiceImpl of register()");

		Customer customer = null;
		Account account = null;
		CustomerDetailsDto customerDetailsDto = null;
		if (customerDto != null) {
				if (emailValidation(customerDto.getEmail())) {

					customer = new Customer();
					account = new Account();
					BeanUtils.copyProperties(customerDto, customer);

					customerRepository.save(customer);
					account.setAccountNumber(random.nextInt(1000000));
					account.setAccountType(customerDto.getAccountType());
					account.setBalance(10000.0);
					account.setCustomer(customer);
					accountRepository.save(account);

					customerDetailsDto = new CustomerDetailsDto();
					customerDetailsDto.setAccountNumber(account.getAccountNumber());
					customerDetailsDto.setMessage("You have Successfully Registered.....");
					customerDetailsDto.setStatus("SUCCESS");

				} else {
					throw new EmailException("Enter Valid Email...");
				}
			} 
		return customerDetailsDto;
	}

	static boolean emailValidation(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
}
