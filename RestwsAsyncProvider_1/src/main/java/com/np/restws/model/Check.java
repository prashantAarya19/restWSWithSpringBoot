package com.np.restws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Check {
	private String checkNumber;
	private String accountNumber;
	private Double ammount;
	
	public String getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAmmount() {
		return ammount;
	}
	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}
	
	
	
}
