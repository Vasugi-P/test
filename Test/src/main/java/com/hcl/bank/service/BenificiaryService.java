
package com.hcl.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.bank.dto.BenificiaryDTO;
import com.hcl.bank.dto.BenificiaryRequest;
import com.hcl.bank.dto.CustomerDto;
import com.hcl.bank.entity.Account;
import com.hcl.bank.entity.Benificiary;
import com.hcl.bank.entity.Customer;
import com.hcl.bank.exception.AccountNotFoundException;
import com.hcl.bank.exception.BenificiaryNotFoundException;
import com.hcl.bank.exception.CustomerNotLoggedInException;
import com.hcl.bank.exception.UserNotFoundException;
import com.hcl.bank.repository.AccountRepository;
import com.hcl.bank.repository.BenificiaryRepository;
import com.hcl.bank.repository.CustomerRepository;

@Service
public class BenificiaryService {

	@Autowired
	BenificiaryRepository benificiaryRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerService;

	@Autowired
	CustomerRepository customerRepository;

	Logger log = LoggerFactory.getLogger(BenificiaryService.class);

	public String addBenificiary(BenificiaryRequest benificiaryRequest)
			throws UserNotFoundException, AccountNotFoundException, BeansException, CustomerNotLoggedInException {

		Optional<Customer> customer = customerRepository.findById(benificiaryRequest.getCustomerId());

		Benificiary benificiary = new Benificiary();

		benificiary.setBenificiaryAccountNumber(benificiaryRequest.getAccountNumber());
		benificiary.setBenificiaryName(benificiaryRequest.getName());

		benificiary.setCustomer(customer.get());

		benificiaryRepository.save(benificiary);

		log.info("Benificiary added successfully.");
		return "Benificiary added successfully.";
	}

	public String updatedBenificiary(BenificiaryDTO benificiaryRequest)
			throws BenificiaryNotFoundException, UserNotFoundException, AccountNotFoundException {

		Optional<Customer> customer = customerRepository.findById(benificiaryRequest.getCustomerId());

		if (!customer.isPresent()) {
			throw new UserNotFoundException("customer not found exception");
		}

		Optional<Account> account = accountRepository
				.findByAccountNumber(benificiaryRequest.getBenificiaryAccountNumber());

		if (!account.isPresent()) {
			throw new AccountNotFoundException("account not found exception");
		}

		Benificiary benificiary = benificiaryRepository.findByCustomerId(benificiaryRequest.getCustomerId());

		benificiary.setBenificiaryAccountNumber(benificiaryRequest.getBenificiaryAccountNumber());

		benificiary.setBenificiaryName(benificiaryRequest.getBenificiaryName());

		Customer customerDto = customerRepository.findByCustomerId(benificiaryRequest.getCustomerId());


		benificiary.setCustomer(customer.get());

		benificiaryRepository.save(benificiary);

		log.info("Benificiary added successfully.");

		return "Benificiary updated successfully.";

	}

	public String deleteBenificiary(Long benificiaryId) throws BenificiaryNotFoundException {

		Optional<Benificiary> benificiary = benificiaryRepository.findById(benificiaryId);
		if (benificiary.isPresent()) {
			benificiaryRepository.deleteById(benificiary.get().getBenificiaryId());

			return "Benificiar Deleted Successfully";
		} else {
			throw new BenificiaryNotFoundException("benificiary not found exception");
		}

	}

	public BenificiaryDTO getBenificiaryByBenificiaryId(Long benificiaryId) throws BenificiaryNotFoundException {

		Optional<Benificiary> benificiary = benificiaryRepository.findById(benificiaryId);

		if (benificiary.isPresent()) {

			BenificiaryDTO benificiaryDto = new BenificiaryDTO();
			benificiaryDto.setBenificiaryAccountNumber(benificiary.get().getBenificiaryAccountNumber());
			benificiaryDto.setBenificiaryName(benificiary.get().getBenificiaryName());
			benificiaryDto.setCustomerId(benificiary.get().getCustomer().getCustomerId());
			return benificiaryDto;

		} else {
			throw new BenificiaryNotFoundException("benificiary not found exception");
		}
	}

}
