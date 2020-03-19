package com.hcl.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.bank.entity.Benificiary;

@Repository
public interface BenificiaryRepository extends JpaRepository<Benificiary, Long> {

	Benificiary findByBenificiaryAccountNumber(Long benificiaryAccountNumber);

	@Query(value = "select * from benificiary where  benificiary_account_number=?1  and  customer_customer_id=?2", nativeQuery = true)
	Optional<Benificiary> findByUserIdAndAccountNumber(Long accountNumber, Long userId);

	@Query(value = "select * from benificiary where customer_customer_id=?1", nativeQuery = true)
	Benificiary findByCustomerId(Long customerId);

}
