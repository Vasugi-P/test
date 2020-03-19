package com.hcl.bank.controller;

import static org.junit.Assert.assertEquals;

import javax.naming.InsufficientResourcesException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.bank.dto.FundTransferdto;
import com.hcl.bank.entity.Account;
import com.hcl.bank.exception.AccountNotFoundException;
import com.hcl.bank.service.FundService;
import com.hcl.bank.service.TransactionService;

@RunWith(MockitoJUnitRunner.class)
public class FundControllerTest {
	
	@Mock
	FundService fundService;
	
	@Mock
	TransactionService transactionService;
	
	@InjectMocks
	FundController fundController;
	
	FundTransferdto fundTransferdto=null;
	Account account=null;
	
	@Before()
	public void before() {
		fundTransferdto=new FundTransferdto();
		fundTransferdto.setFromAccount(100L);
		fundTransferdto.setToAccount(100L);
		fundTransferdto.setAmount(400.0);
		fundTransferdto.setDescription("ok");		
	}
	
	@Test
	public void fundTransferTest() throws InsufficientResourcesException, AccountNotFoundException {
		String expected="fundTransferMessage";
		Mockito.when(fundService.fundTransfer(fundTransferdto)).thenReturn(expected);
		ResponseEntity<String> response=fundController.fundTransfer(fundTransferdto);
		assertEquals(expected, response.getBody());		
	}
	
	
	@Test
	public void fundTransferTestNegative() throws InsufficientResourcesException, AccountNotFoundException {
		
		fundTransferdto=new FundTransferdto();
		fundTransferdto.setFromAccount(200L);
		fundTransferdto.setToAccount(200L);
		fundTransferdto.setAmount(2000.0);
		fundTransferdto.setDescription(" not ok");	
		
		String expected="account not found,Insufficient fund";
		Mockito.when(fundService.fundTransfer(fundTransferdto)).thenReturn(expected);
		ResponseEntity<String> response=fundController.fundTransfer(fundTransferdto);
		assertEquals(expected, response.getBody());		
	}
	
	
	
	

}
