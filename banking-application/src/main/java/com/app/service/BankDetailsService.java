package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BankDetailsRepository;
import com.app.model.BankDetails;
import com.app.model.BankUser;

@Service
public class BankDetailsService {

	@Autowired
	private BankDetailsRepository bankDetailsRepository;

	public BankDetails addBankDetails(BankDetails bankDetails) {

		return bankDetailsRepository.save(bankDetails);
	}

	public List<BankDetails> getAllBankDetails() {
		return bankDetailsRepository.findAll();
	}
}
