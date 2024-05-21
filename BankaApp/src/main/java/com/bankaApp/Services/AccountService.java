package com.bankaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaApp.Model.Account;
import com.bankaApp.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> getAllAccounts(){
	
		List<Account> accounts=accountRepository.findAll();
		return accounts;
		
	}
	
	public Account getAccountById(int id){
		Account account = accountRepository.findById(id);
		return account;
	}
	
	public List<Account> grtAllAccountByClientMail(String mail){
		List<Account> accounts = accountRepository.findByClientMail(mail);
		return accounts;
	}
}
