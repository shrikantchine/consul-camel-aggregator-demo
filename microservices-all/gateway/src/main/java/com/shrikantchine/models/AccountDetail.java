package com.shrikantchine.models;

public class AccountDetail {

	private String accountId;
	private String accountName;
	private String accountType;
	
	public AccountDetail() {}
	
	public AccountDetail(String accountId, String accountName, String accountType) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountType = accountType;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	


}
