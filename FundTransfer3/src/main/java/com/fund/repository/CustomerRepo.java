package com.fund.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fund.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

	Customer findByCustomerId(Long customerId);


}
