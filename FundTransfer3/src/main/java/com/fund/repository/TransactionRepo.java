package com.fund.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fund.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>{
	List<Transaction> findByAccounts(Long accounts);

}
