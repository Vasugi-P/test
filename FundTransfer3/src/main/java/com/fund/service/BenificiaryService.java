package com.fund.service;



import com.fund.dto.BenificiaryDto;
import com.fund.entity.Benificiary;

public interface BenificiaryService {

	public void deleteBenificiary(Long benificiaryId);

	Benificiary getAllBenificiary(Long benificiaryId);

	//List<Benificiary> getAllBenificiaryByCustomerId(Long customerId);
	
	public void createBenificiary(BenificiaryDto benificiaryDto);

	
	
}
