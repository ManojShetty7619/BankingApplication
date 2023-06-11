
package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.BankUser;
import com.app.service.BankUserService;

@RestController
public class BankUserController {

	@Autowired
	private BankUserService bankUserService;

	@RequestMapping("/addBankUser")
	public BankUser addBankUser(@RequestBody BankUser bankUser) {
		return bankUserService.addBankUser(bankUser);
	}

	@GetMapping("/getAllBankUser")
	public List<BankUser> getAlluserDetail() {
		return bankUserService.getAllBankUser();

	}

}
