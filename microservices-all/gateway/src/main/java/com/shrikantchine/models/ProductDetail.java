package com.shrikantchine.models;

public class ProductDetail {
	private String productId;
	private String productName;
	private String category;
	
	public ProductDetail(String productId, String productName, String category) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
