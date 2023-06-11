package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.BankUser;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser, Integer> {

	BankUser findByUserName(String userName);

	BankUser findByPassword(String password);

	BankUser findByAccBalance(String accBalance);

	BankUser findByDepositAmount(String depositAmount);

	BankUser findByWithdrawAmount(String withdrawAmount);

}
