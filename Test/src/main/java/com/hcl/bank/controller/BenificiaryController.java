package com.hcl.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.bank.dto.BenificiaryDTO;
import com.hcl.bank.dto.BenificiaryRequest;
import com.hcl.bank.exception.AccountNotFoundException;
import com.hcl.bank.exception.BenificiaryNotFoundException;
import com.hcl.bank.exception.CustomerNotLoggedInException;
import com.hcl.bank.exception.UserNotFoundException;
import com.hcl.bank.service.BenificiaryService;

@RestController
@RequestMapping("/benificiaries")
public class BenificiaryController {

	//private Logger logger = LoggerFactory.getLogger(BenificiaryController.class);

	@Autowired
	BenificiaryService benificiaryService;

	@PostMapping("")
	public ResponseEntity<String> addBenificiary(@RequestBody BenificiaryRequest benificiaryRequest)
			throws UserNotFoundException, AccountNotFoundException, BeansException, CustomerNotLoggedInException {

		String message = benificiaryService.addBenificiary(benificiaryRequest);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@PutMapping("")
	public ResponseEntity<String> updateBenificiary(@RequestBody BenificiaryDTO benificiaryRequest)
			throws BenificiaryNotFoundException, UserNotFoundException, AccountNotFoundException {

		String message =benificiaryService.updatedBenificiary(benificiaryRequest);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@DeleteMapping("/{benificiaryId}")
	public ResponseEntity<String> deleteBenificiary(@PathVariable("benificiaryId") Long benificiaryId)
			throws BenificiaryNotFoundException {
		String message =benificiaryService.deleteBenificiary(benificiaryId);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping("/{benificiaryId}")
	public ResponseEntity<Object> getBenificiaryByBenificiaryId(@PathVariable("benificiaryId") Long benificiaryId)
			throws BenificiaryNotFoundException {
		BenificiaryDTO benificiaryDTO = benificiaryService.getBenificiaryByBenificiaryId(benificiaryId);
		return new ResponseEntity<>(benificiaryDTO, HttpStatus.OK);
	}
}
