package com.hcl.bank.service;



import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.bank.controller.BenificiaryController;
import com.hcl.bank.dto.BenificiaryDTO;
import com.hcl.bank.dto.BenificiaryRequest;
import com.hcl.bank.dto.ResponseDto;
import com.hcl.bank.entity.Benificiary;
import com.hcl.bank.entity.Customer;
import com.hcl.bank.exception.AccountNotFoundException;
import com.hcl.bank.exception.BenificiaryNotFoundException;
import com.hcl.bank.exception.CustomerNotLoggedInException;
import com.hcl.bank.exception.UserNotFoundException;
import com.hcl.bank.repository.BenificiaryRepository;
import com.hcl.bank.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BenificiaryServiceTest {

	BenificiaryDTO benificiaryDto = null;
	BenificiaryRequest benificiaryRequest = null;

	@Mock
	BenificiaryRepository benificiaryRepository;
	
	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	BenificiaryService benificiaryService;
	
	Benificiary beneficiary = null;

	/*
	 * @Before public void add() { beneficiary=new Benificiary();
	 * beneficiary.setBenificiaryAccountNumber(1);
	 * beneficiary.setBenificiaryName("ram"); beneficiary.setBenificiaryId(1); }
	 */

	@Before
	public void add() {
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		beneficiary = new Benificiary();
		beneficiary.setBenificiaryAccountNumber(1L);
		beneficiary.setBenificiaryName("ram");
		beneficiary.setCustomer(customer);
		benificiaryRequest = new BenificiaryRequest();
		benificiaryRequest.setAccountNumber(1L);
		benificiaryRequest.setName("ram");
		benificiaryRequest.setCustomerId(4L);

	}

	@Test
	public void testaddBenificiary() throws BeansException, UserNotFoundException, AccountNotFoundException, CustomerNotLoggedInException {
		Customer customer=new Customer();
		customer.setCustomerId(1L);
		beneficiary = new Benificiary();
		beneficiary.setBenificiaryAccountNumber(1L);
		beneficiary.setBenificiaryName("ram");
		beneficiary.setCustomer(customer);
		benificiaryRequest = new BenificiaryRequest();
		benificiaryRequest.setAccountNumber(1L);
		benificiaryRequest.setName("ram");
		benificiaryRequest.setCustomerId(4L);
		
		Mockito.when(benificiaryRepository.save(beneficiary)).thenReturn(beneficiary);
		Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
		String response=benificiaryService.addBenificiary(benificiaryRequest);
		//System.out.println(response);
		assertEquals(response, "benificiary added successfully");
		
	}
	
	@Test
	public void testDeletePositive() throws BenificiaryNotFoundException {
		Long benificiaryId = 1L;
		Mockito.when(benificiaryRepository.findById(benificiaryId)).thenReturn(Optional.of(beneficiary));
		String response = benificiaryService.deleteBenificiary(benificiaryId);
		String expected = "Benificiar Deleted Successfully";
		assertEquals(expected, response);
	}

	@Test(expected = BenificiaryNotFoundException.class)
	public void testDeleteNegative() throws BenificiaryNotFoundException {
		Long benificiaryId = 1L;
		Mockito.when(benificiaryRepository.findById(benificiaryId)).thenReturn(Optional.ofNullable(null));
		benificiaryService.deleteBenificiary(1L);
	}
	
	
	
	
	/*@Test void testGetAllBenificiaryByBenificiaryId() {
		Long benificiaryId=1L;
		Mockito.when(benificiaryService.)thenReturn(benificiaryId);
		ResponseEntity<Object> response=benificiaryService.getBenificiaryByBenificiaryId(benificiaryId);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}*/
	
	
	
	

}
