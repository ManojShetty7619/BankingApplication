package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BankDetailsRepository;
import com.app.dao.BankUserRepository;
import com.app.model.BankDetails;
import com.app.model.BankUser;
import com.app.service.BankDetailsService;

@RestController
public class BankDetailsController {

	@Autowired
	private BankDetailsService bankDetailsService;

	@Autowired
	private BankUserRepository bankUserRepository;

	@Autowired
	private BankDetailsRepository bankDetailsRepository;

	@RequestMapping("/addBankDetails")
	public BankDetails addBankDetails(@RequestBody BankDetails bankDetails) {
		return bankDetailsService.addBankDetails(bankDetails);
	}

	@GetMapping("/getAllBankDetails")
	public List<BankDetails> getAllBankDetails() {
		return bankDetailsService.getAllBankDetails();

	}

	@PostMapping("/validateBankUser")
	public String validateBankUser(@RequestBody BankDetails bankDetails, HttpServletRequest httpServletRequest) {
		String str = "";
		String userName = httpServletRequest.getHeader("userName");
		String password = httpServletRequest.getHeader("password");
		String accNo = httpServletRequest.getHeader("accNo");

//		String accBalance = httpServletRequest.getHeader("accBalance");
//		String depositAmount = httpServletRequest.getHeader("depositAmount");
//		String withdrawAmount = httpServletRequest.getHeader("withdrawAmount");

		BankUser bankUser = bankUserRepository.findByUserName(userName);

		String accBalance = bankUser.getAccBalance();
		String depositAmount = bankUser.getDepositAmount();
		String withdrawAmount = bankUser.getWithdrawAmount();

		int accBalance1 = Integer.valueOf(accBalance);
		int depositAmount1 = Integer.valueOf(depositAmount);
		int withdrawAmount1 = Integer.valueOf(withdrawAmount);

		if (password.equals(bankUser.getPassword())) {
			bankDetailsRepository.save(bankDetails);
			str = "valid user";

			if (accNo.equals(bankUser.getAccNo())) {
				int newAccBalance = accBalance1 + depositAmount1;
				str = "Account balance :" + newAccBalance;

				if (withdrawAmount1 <= newAccBalance) {
					str = "Amount deposited :" + depositAmount + "\n" + "Remaining amount :"
							+ (newAccBalance - withdrawAmount1);
				} else {
					str = "Low balance";
				}

			} else {
				str = "invalid account numberF";
			}

		} else {
			str = "invalis user";
		}

		return str;

	}

}
