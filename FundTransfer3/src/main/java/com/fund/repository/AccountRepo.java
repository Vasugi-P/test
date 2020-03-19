package com.fund.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fund.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{
	
	Optional<Account> findByAccountNumber(Long accountNumber);

}
