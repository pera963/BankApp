package com.bankaApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankaApp.Model.Account;
import com.bankaApp.Services.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
	private AccountService accountService;
    
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccount(){
    	
    	List<Account> accounts=accountService.getAllAccounts();
    	  return new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id){       // @PathVariable - pokupi iz putanje id,koji 'emo mi proslediti u servis
    	Account account = accountService.getAccountById(id);
    	if(account==null) {
    	return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);            // ResponseEntity<Account> response = new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
    	                                                                    //  return response;
    	             
    	}
    	else {
    		return new ResponseEntity<Account>(account,HttpStatus.OK);
    	}
    }
   
    @GetMapping("/ByClientMail")
    public ResponseEntity<List<Account>> getAllAccountByClientMail(@RequestParam String mail){
    	List<Account> accounts = accountService.grtAllAccountByClientMail(mail);
    	return new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
    	
    }
    @GetMapping("/ByAccountTypeDev")    
    public ResponseEntity<List<Account>> getAllAccountByAccountTypeDev(){
    	List<Account> accounts = accountService.getAllAccountByAccountTypeDev();
    	return new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
    }
}








