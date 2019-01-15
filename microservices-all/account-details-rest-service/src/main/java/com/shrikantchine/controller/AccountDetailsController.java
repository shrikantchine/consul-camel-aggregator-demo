package com.shrikantchine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrikantchine.data.AccountDetailsService;
import com.shrikantchine.model.AccountDetailsRequest;
import com.shrikantchine.model.AccountDetailsResponse;

@RestController
@RequestMapping("/")
public class AccountDetailsController {
	
	@Autowired
	private AccountDetailsService service;
	
	@PostMapping("/accounts")
	public AccountDetailsResponse getAccounts(@RequestBody AccountDetailsRequest request) {
		return service.getAccountDetails(request);
	}
}
