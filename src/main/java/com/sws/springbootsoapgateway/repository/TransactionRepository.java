package com.sws.springbootsoapgateway.repository;

import com.sws.springbootsoapgateway.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
