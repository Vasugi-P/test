package com.hcl.bank.dto;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class BenificiaryRequest {
	
	@NotNull
	private Long accountNumber;
	
	private String name;
	
	@NotNull
	private Long customerId;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	

}
