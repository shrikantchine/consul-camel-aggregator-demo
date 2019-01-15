package com.shrikantchine.models;

import java.util.List;

public class ProductDetailsResponse {
	
	private List<ProductDetail> productDetails;
	
	public ProductDetailsResponse() {}

	public ProductDetailsResponse(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public List<ProductDetail> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}
}
