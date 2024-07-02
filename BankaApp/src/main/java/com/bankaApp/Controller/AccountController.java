package com.bankaApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankaApp.DTOS.AccountDTO;
import com.bankaApp.DTOS.ClientDTO;
import com.bankaApp.Model.Account;
import com.bankaApp.Model.Client;
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
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO){
    	Account account = accountService.createAccount(accountDTO);
    	if(account==null) {
    		return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST); 
    	}
    	else {
    		return new ResponseEntity<Account>(account,HttpStatus.OK);
    	}
    }
    
    @PutMapping("/changeStatus/{id}")
    public ResponseEntity<Account> changeStatus(@PathVariable int id){
    	Account account = accountService.updateStatus(id);
    	if(account==null) {
    		return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST); 
    	}
    	else {
    		return new ResponseEntity<Account>(account,HttpStatus.OK);
    	}
    }

    @PutMapping("/{id}")
 	 public ResponseEntity<Account> updateAccount(@PathVariable int id,@RequestBody AccountDTO accountDTO){
 		   Account account = accountService.updateAccount(id, accountDTO);
 		   if(account==null) {
 			   return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
 		   }
 		   else {
 			   return new ResponseEntity<Account>(account,HttpStatus.OK);
 		   }
 			   
 	 }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable int id){
    	Account account = accountService.deleteAccount(id);
 	   if(account==null) {
			   return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		   }
		   else {
			   return new ResponseEntity<Account>(account,HttpStatus.OK);
		   }
    }
      


}








