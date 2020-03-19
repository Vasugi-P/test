package com.hcl.bank.controller;

import javax.naming.InsufficientResourcesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bank.dto.FundTransferdto;
import com.hcl.bank.exception.AccountNotFoundException;
import com.hcl.bank.response.TransactionResponse;
import com.hcl.bank.service.FundService;
import com.hcl.bank.service.TransactionService;

@RestController
@RequestMapping("/fundtransfers")
public class FundController {

	@Autowired
	private FundService fundService;

	@Autowired
	private TransactionService transactionService;

	@PostMapping("")
	public ResponseEntity<String> fundTransfer(@RequestBody FundTransferdto fundTransferdto)
			throws InsufficientResourcesException, AccountNotFoundException {

		String fundTransferMessage = fundService.fundTransfer(fundTransferdto);

		return new ResponseEntity<String>(fundTransferMessage, HttpStatus.OK);

	}

	@GetMapping("/{accountId}")
	public ResponseEntity<TransactionResponse> getTransactionsStatement(@PathVariable("accountId") Long accountId) {

		
		  TransactionResponse transactionResponse =transactionService.getTransactionsStatement(accountId);
		 
		return new ResponseEntity<TransactionResponse>(transactionResponse, HttpStatus.OK);

	}

}
