package com.shrikantchine.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.shrikantchine.model.AccountDetail;
import com.shrikantchine.model.AccountDetailsRequest;
import com.shrikantchine.model.AccountDetailsResponse;

@Service
public class AccountDetailsService {
	Map<String, AccountDetailsResponse> customerToAccountsMap;
	
	@PostConstruct
	public void init() {
		this.customerToAccountsMap = new HashMap<>();
		this.customerToAccountsMap.put("111", new AccountDetailsResponse(Arrays.asList(new AccountDetail("acc-id-1", "account-one", "cheque"), 
																					   new AccountDetail("acc-id-2", "account-two", "saving"))));
		this.customerToAccountsMap.put("222", new AccountDetailsResponse(Arrays.asList(new AccountDetail("acc-id-3", "account-three", "cheque"), 
				   																	   new AccountDetail("acc-id-4", "account-four", "saving"))));
	}
	
	public AccountDetailsResponse getAccountDetails(AccountDetailsRequest request) {
		AccountDetailsResponse accountDetailsResponse = customerToAccountsMap.get(request.getCustomerId());
		return accountDetailsResponse == null ? new AccountDetailsResponse() : accountDetailsResponse;
	}

}
