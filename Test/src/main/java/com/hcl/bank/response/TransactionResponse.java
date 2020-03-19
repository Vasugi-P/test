package com.hcl.bank.response;

import java.util.List;

import com.hcl.bank.dto.Transactiondto;


public class TransactionResponse {

	private Integer sizeOfList;

	private List<Transactiondto> fundTransfer;

	public Integer getSizeOfList() {
		return sizeOfList;
	}

	public void setSizeOfList(Integer sizeOfList) {
		this.sizeOfList = sizeOfList;
	}

	public List<Transactiondto> getFundTransfer() {
		return fundTransfer;
	}

	public void setFundTransfer(List<Transactiondto> fundTransfer) {
		this.fundTransfer = fundTransfer;
	}

}
