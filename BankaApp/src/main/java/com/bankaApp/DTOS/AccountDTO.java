package com.bankaApp.DTOS;


public class AccountDTO {

    private String accountNumber;
	
	private boolean status;
	
	private String accountType;
	
	private double balance;
		
	private int  client_Id;

	public AccountDTO() {
		super();
	}

	public AccountDTO(String accountNumber, boolean status, String accountType, double balance, int client_Id) {
		super();
		this.accountNumber = accountNumber;
		this.status = status;
		this.accountType = accountType;
		this.balance = balance;
		this.client_Id = client_Id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getClient_Id() {
		return client_Id;
	}

	public void setClient_Id(int client_Id) {
		this.client_Id = client_Id;
	}
	
	
}
