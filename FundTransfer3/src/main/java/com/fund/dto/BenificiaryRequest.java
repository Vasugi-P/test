package com.fund.dto;

public class BenificiaryRequest {
	
	private Long accountNumber;
	private String benificiaryName;
	private Long customerId;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBenificiaryName() {
		return benificiaryName;
	}
	public void setBenificiaryName(String benificiaryName) {
		this.benificiaryName = benificiaryName;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	
	

}
