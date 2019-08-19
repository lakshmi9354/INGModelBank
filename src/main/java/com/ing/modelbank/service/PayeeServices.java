package com.ing.modelbank.service;

import com.ing.modelbank.config.dto.ResponseDto;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.entity.Otp;
import com.ing.modelbank.entity.Payee;
import com.ing.modelbank.exception.OtpException;
import com.ing.modelbank.exception.PayeeException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.api.MailService;
import com.ing.modelbank.api.OtpApi;
import com.ing.modelbank.config.dto.PayeeDetailsDto;
import com.ing.modelbank.config.dto.PayeeListDto;
import com.ing.modelbank.repository.AccountRepository;
import com.ing.modelbank.repository.CustomerRepository;
import com.ing.modelbank.repository.OtpRepository;
import com.ing.modelbank.repository.PayeeRepository;

@Service
public class PayeeServices implements PayeeServiceImpl {
	
	@Autowired
	PayeeRepository payeeRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	MailService emailService;
	
	@Autowired
	OtpRepository otpRepository;
	
	Otp otpEntity;
	
	public ResponseDto addPayee(PayeeListDto payee) throws PayeeException
	{
		OtpApi optapi = new OtpApi();
		//System.out.println(String.valueOf(optapi.OTP(6)));
		String otp = String.valueOf(optapi.OTP(6));
		Date date = new Date();
		Payee payeeList = new Payee();
		payeeList.setDate(date);
		BeanUtils.copyProperties(payee, payeeList);	
		
		
		
		Optional<Account> accountDetails = accountRepository.findByAccountId(payeeList.getAccountId());
		Optional<Customer> customerDetails = customerRepository.findByCustomerId(accountDetails.get().getCustomerId());
		/*System.out.println("accountDetails "+accountDetails.get().getCustomerId());
		System.out.println("customerDetails "+customerDetails.get().getCustomerId());
		System.out.println("customerDetails "+customerDetails.get().getEmail());*/
		
		
		if(payeeRepository.save(payeeList) == null)
		{
			throw new PayeeException("Payee Not added successfully");
		}
		else
		{
			if(customerDetails.isPresent())
			{
				otpEntity = new Otp();
				emailService.sendEmail(otp, customerDetails.get().getEmail());
				otpEntity.setOtpNo(Integer.parseInt(otp));
				otpEntity.setCustomerId(customerDetails.get().getCustomerId());
				otpRepository.save(otpEntity);
			}			
			return new ResponseDto("added successfully");
		}
	}

	
	public ResponseDto verifyDto(int otpNo) throws OtpException
	{
		Otp otpData = otpRepository.findByotpNo(otpNo);
		if(otpData.getOtpNo() == otpNo)
			return new ResponseDto("Otp verified successfully");
		else
			throw new OtpException("Otp is not successfull");
	}


	@Override
	public List<PayeeDetailsDto> payees(Integer accountId) {
		List<Payee> payeeList = payeeRepository.findByCustomerId(accountId);
		List<PayeeDetailsDto> payeeDetailsDtos = new ArrayList<PayeeDetailsDto>();
		for(Payee payeeList2 : payeeList) {
			PayeeDetailsDto payeeDetailsDto = new PayeeDetailsDto();
			BeanUtils.copyProperties(payeeList2, payeeDetailsDto);
			payeeDetailsDtos.add(payeeDetailsDto);
		}
		return payeeDetailsDtos;
	}
	
}
