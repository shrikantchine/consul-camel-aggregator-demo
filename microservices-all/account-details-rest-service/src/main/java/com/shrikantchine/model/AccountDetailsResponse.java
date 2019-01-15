package com.shrikantchine.model;

import java.util.List;

public class AccountDetailsResponse {
	
	private List<AccountDetail> AccountDetail;
	
	public AccountDetailsResponse() {}

	public AccountDetailsResponse(List<AccountDetail> AccountDetail) {
		this.AccountDetail = AccountDetail;
	}

	public List<AccountDetail> getAccountDetail() {
		return AccountDetail;
	}

	public void setAccountDetail(List<AccountDetail> AccountDetail) {
		this.AccountDetail = AccountDetail;
	}
}
