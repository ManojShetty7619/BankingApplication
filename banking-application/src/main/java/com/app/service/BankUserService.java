package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BankUserRepository;
import com.app.model.BankUser;

@Service
public class BankUserService {

	@Autowired
	private BankUserRepository bankuserRepository;

	public BankUser addBankUser(BankUser bankUser) {
		return bankuserRepository.save(bankUser);
	}

	public List<BankUser> getAllBankUser() {
		return bankuserRepository.findAll();
	}

}
