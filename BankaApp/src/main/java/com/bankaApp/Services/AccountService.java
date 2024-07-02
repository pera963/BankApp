package com.bankaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaApp.DTOS.AccountDTO;
import com.bankaApp.DTOS.ClientDTO;
import com.bankaApp.Model.Account;
import com.bankaApp.Model.Branch;
import com.bankaApp.Model.Client;
import com.bankaApp.repositories.AccountRepository;
import com.bankaApp.repositories.ClientRepository;



@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ClientRepository clientRepository;
	
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
	
	public List<Account> getAllAccountByAccountTypeDev(){
		List<Account> accounts = accountRepository.findByAccountType();
		return accounts;
		
	}
	
	public Account createAccount(AccountDTO accountDTO) {
		Client client = clientRepository.findById(accountDTO.getClient_Id());
		if(client==null) {
			return null;
		}
		Account account = new Account();
		account.setAccountNumber(accountDTO.getAccountNumber());
		account.setAccountType(accountDTO.getAccountType());
		account.setStatus(accountDTO.isStatus());
		account.setBalance(accountDTO.getBalance());
		account.setClient(client);
		return accountRepository.save(account);
	}
	
	public Account updateStatus(int id) {
		Account account = accountRepository.findById(id);
		if(account==null) {
			return null;
		}
		
		if(account.isStatus()==true) {
			account.setStatus(false);
			
		}
		else {
			account.setStatus(true);
		}
		return accountRepository.save(account);
	}
	
	
	 public Account updateAccount(int id,AccountDTO accountDTO) {
	    	Account account= accountRepository.findById(id);
	    	if(account==null) {
	    		return null;
	    	}
	    	Client client = clientRepository.findById(accountDTO.getClient_Id());
			if(client==null) {
				return null;
			}   	
	    	account.setAccountNumber(accountDTO.getAccountNumber());
	    	account.setStatus(accountDTO.isStatus());
	    	account.setAccountType(accountDTO.getAccountType());
	    	account.setBalance(accountDTO.getBalance());
	    	account.setClient(client);
	      	return accountRepository.save(account);
	    }
	 
	 public Account deleteAccount(int id){
	    	
		 Account account = accountRepository.findById(id);
	        if(account==null) {
	    	   return null;
	    	}
	        accountRepository.delete(account);
	        return account;
	    }
	
}

