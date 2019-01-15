package com.shrikantchine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrikantchine.data.CustomerDetailsService;
import com.shrikantchine.model.CustomerDetailsRequest;
import com.shrikantchine.model.CustomerDetailsResponse;

@RestController
@RequestMapping("/")
public class CustomerDetailsController {
	
	@Autowired
	private CustomerDetailsService service;
	
	@PostMapping("/customer")
	public CustomerDetailsResponse getCustomers(@RequestBody CustomerDetailsRequest request) {
		return service.getCustomerDetails(request);
	}
}
