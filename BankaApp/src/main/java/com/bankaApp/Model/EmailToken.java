package com.bankaApp.Model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class EmailToken {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String token;
	private LocalDateTime creationDate;
	private LocalDateTime expirationDate;
	private LocalDateTime confirmationDate;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Client client;
	public EmailToken() {
		super();
	}

	public EmailToken(int id, String token, LocalDateTime creationDate, LocalDateTime expirationDate,
			LocalDateTime confirmationDate, Client client) {
		super();
		this.id = id;
		this.token = token;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
		this.confirmationDate = confirmationDate;
		this.client = client;
	}

	public EmailToken(String token, LocalDateTime creationDate, LocalDateTime expirationDate,
			 Client client) {
		super();
		this.token = token;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public LocalDateTime getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(LocalDateTime confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
