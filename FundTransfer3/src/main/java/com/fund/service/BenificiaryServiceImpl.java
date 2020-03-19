package com.fund.service;



import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fund.dto.BenificiaryDto;
import com.fund.entity.Benificiary;
import com.fund.entity.Customer;
import com.fund.exception.BenificiaryNotFoundException;
import com.fund.repository.BenificiaryRepo;
import com.fund.repository.CustomerRepo;

@Service
@Transactional
public class BenificiaryServiceImpl implements BenificiaryService {

	@Autowired
	private BenificiaryRepo beneRepo;
	
	@Autowired
	private CustomerRepo cusRepo;

	@Override
	public void deleteBenificiary(Long benificiaryId) {
		beneRepo.deleteById(benificiaryId);

	}

	@Override
	public Benificiary getAllBenificiary(Long benificiaryId) {
		Benificiary benificiary = beneRepo.findById(benificiaryId).orElseThrow(BenificiaryNotFoundException::new);
		return benificiary;
	}

	@Override
	public void createBenificiary(BenificiaryDto benificiaryDto) {
		Benificiary bene=new Benificiary();
				bene.setBenificiaryAccountNumber(benificiaryDto.getBenificiaryAccountNumber());
				bene.setBenificiaryName(benificiaryDto.getBenificiaryName());
		Customer cus=cusRepo.findByCustomerId(benificiaryDto.getCustomerId());
		List<Benificiary>benificiary=new ArrayList<Benificiary>();
		benificiary.add(bene);
		
		cus.setBenificiaries(benificiary);
		 cusRepo.save(cus);
		
		
		
		
		
	}

	
	
	
	
	
}
