package com.shrikantchine.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.shrikantchine.model.ProductDetail;
import com.shrikantchine.model.ProductDetailsRequest;
import com.shrikantchine.model.ProductDetailsResponse;

@Service
public class ProductDetailsService {
	Map<String, ProductDetailsResponse> customerToProductDetailsMap;
	
	@PostConstruct
	public void init() {
		this.customerToProductDetailsMap = new HashMap<>();
		this.customerToProductDetailsMap.put("111", new ProductDetailsResponse(Arrays.asList(new ProductDetail("101", "OnePlus 6T", "Mobile Phones"), 
																							 new ProductDetail("102", "Hyundai Elantra", "Cars"))));
		this.customerToProductDetailsMap.put("222", new ProductDetailsResponse(Arrays.asList(new ProductDetail("103", "Apple iPhone", "Mobile Phones"), 
				 																			 new ProductDetail("104", "Honda Civic", "Cars"))));
	}
	
	public ProductDetailsResponse getProductDetails(ProductDetailsRequest request) {
		ProductDetailsResponse productDetails = customerToProductDetailsMap.get(request.getCustomerId());
		return productDetails == null ? new ProductDetailsResponse() : productDetails;
	}

}