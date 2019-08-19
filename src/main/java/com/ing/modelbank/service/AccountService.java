package com.ing.modelbank.service;

import com.ing.modelbank.dto.AccountDetailsDto;

public interface AccountService {

	AccountDetailsDto getAccountSummary(Integer accountId);

}
