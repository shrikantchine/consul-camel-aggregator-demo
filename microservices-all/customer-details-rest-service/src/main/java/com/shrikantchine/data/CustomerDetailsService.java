package com.shrikantchine.data;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.shrikantchine.model.CustomerDetailsRequest;
import com.shrikantchine.model.CustomerDetailsResponse;

@Service
public class CustomerDetailsService {
	Map<String, CustomerDetailsResponse> customerToDetailsMap;
	
	@PostConstruct
	public void init() {
		this.customerToDetailsMap = new HashMap<>();
		this.customerToDetailsMap.put("111", new CustomerDetailsResponse("111", "John", "Doe", 20));
		this.customerToDetailsMap.put("222", new CustomerDetailsResponse("111", "Jane", "Doe", 16));
	}
	
	public CustomerDetailsResponse getCustomerDetails(CustomerDetailsRequest request) {
		CustomerDetailsResponse customerDetails = customerToDetailsMap.get(request.getCustomerId());
		return customerDetails == null ? new CustomerDetailsResponse(request.getCustomerId(), "Unknown", "Unknown", 0) : customerDetails;
	}

}
