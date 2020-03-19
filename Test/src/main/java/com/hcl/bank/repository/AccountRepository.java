package com.hcl.bank.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.bank.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	
	
	@Query(value = "select * from account where account_number=?",nativeQuery = true)
	Account findByAccount(Long accountNumber);

	Optional<Account> findByAccountNumber(Long fromAccount);

}
