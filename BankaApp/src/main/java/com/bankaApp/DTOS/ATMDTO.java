package com.bankaApp.DTOS;


public class ATMDTO {

	private String name;
	private double balance;
	private boolean activeStatus;
	
	private int branch_Id;

	public ATMDTO() {
		super();
	}

	public ATMDTO(String name, double balance, boolean activeStatus, int branch_Id) {
		super();
		this.name = name;
		this.balance = balance;
		this.activeStatus = activeStatus;
		this.branch_Id = branch_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public int getBranch_Id() {
		return branch_Id;
	}

	public void setBranch_Id(int branch_Id) {
		this.branch_Id = branch_Id;
	}
	
	
}
