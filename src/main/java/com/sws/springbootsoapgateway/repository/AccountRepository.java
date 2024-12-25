package com.sws.springbootsoapgateway.repository;

import com.sws.springbootsoapgateway.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByAccountNumber(String accountNumber);
}
