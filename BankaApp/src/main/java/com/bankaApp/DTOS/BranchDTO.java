package com.bankaApp.DTOS;

public class BranchDTO {

    private String name;
	
	private String city;
	
	private String address;
	
	private String phoneNumber;
	
	
	public BranchDTO() {
		super();
	}

	public BranchDTO(String name, String city, String address, String phoneNumber) {
		super();
		this.name = name;
		this.city = city;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
