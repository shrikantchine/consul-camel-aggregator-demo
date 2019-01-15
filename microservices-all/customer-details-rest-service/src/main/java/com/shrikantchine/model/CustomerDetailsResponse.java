package com.shrikantchine.model;

public class CustomerDetailsResponse {
	private String customerId;
	private String fistName;
	private String lastName;
	private int age;
	
	public CustomerDetailsResponse(String customerId, String fistName, String lastName, int age) {
		this.customerId = customerId;
		this.fistName = fistName;
		this.lastName = lastName;
		this.age = age;
	}
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
	
	
	
}
