package com.shrikantchine.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.shrikantchine.soap.orderdetailsservice.v1.OrderDetailsResponse;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder= {
		"customerId", 
		"fistName", 
		"lastName", 
		"age", 
		"accountDetails", 
		"productDetails", 
		"orderDetails"
})
public class OrderProductAccountResponse {
	
	private String customerId;
	private String fistName;
	private String lastName;
	private int age;
	private AccountDetailsResponse accountDetails;
	private ProductDetailsResponse productDetails;
	private OrderDetailsResponse orderDetails;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public AccountDetailsResponse getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(AccountDetailsResponse accountDetails) {
		this.accountDetails = accountDetails;
	}
	public ProductDetailsResponse getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(ProductDetailsResponse productDetails) {
		this.productDetails = productDetails;
	}
	public OrderDetailsResponse getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetailsResponse orderDetails) {
		this.orderDetails = orderDetails;
	}
}
