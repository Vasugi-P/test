package com.hcl.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bank.entity.FundTransfer;
@Repository
public interface FundTransferRepository extends JpaRepository<FundTransfer, Long>{


}
