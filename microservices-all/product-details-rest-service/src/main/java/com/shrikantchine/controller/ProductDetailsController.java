package com.shrikantchine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrikantchine.model.ProductDetailsRequest;
import com.shrikantchine.model.ProductDetailsResponse;
import com.shrikantchine.service.ProductDetailsService;

@RestController
@RequestMapping("/")
public class ProductDetailsController {
	
	@Autowired
	private ProductDetailsService service;
	
	@PostMapping("/products")
	public ProductDetailsResponse getProductDetails(@RequestBody ProductDetailsRequest request) {
		return service.getProductDetails(request);
	}
}
