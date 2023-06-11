package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankDetails {
	@Id
	private int bankId;
	private String bankName;
	private String bankAdress;

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAdress() {
		return bankAdress;
	}

	public void setBankAdress(String bankAdress) {
		this.bankAdress = bankAdress;
	}

}
