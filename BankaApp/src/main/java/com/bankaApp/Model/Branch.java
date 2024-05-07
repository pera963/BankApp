package com.bankaApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	private String name;
	
	private String city;
	
	private String address;
	
	private String phoneNumber;

	public Branch(int id, String name, String city, String address, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Branch() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
