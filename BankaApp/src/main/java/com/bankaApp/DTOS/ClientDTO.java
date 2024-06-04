package com.bankaApp.DTOS;

public class ClientDTO {

	
	
    private String name;
	
	private String surname;
	
	private String mail;
	
	private String address;
	
	private String phoneNumber;
	
	private String userName;
	
	private String password;

	public ClientDTO() {
		super();
		
	}

	public ClientDTO(String name, String surname, String mail, String address, String phoneNumber, String userName,
			String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}

