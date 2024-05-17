package com.bankaApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankaApp.Model.Branch;
import com.bankaApp.Model.Client;
import com.bankaApp.Services.BranchService;
import com.bankaApp.Services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	 @GetMapping
	    public ResponseEntity<List<Client>> getAllClient(){
	    	
	    	List<Client> client=clientService.getAllClient();
	    	  return new ResponseEntity<List<Client>>(client,HttpStatus.OK);
	    }
	 
	 @GetMapping("/ByMail")
	 public ResponseEntity<Client> getClientByMail(@RequestParam String mail){                      //Key je ključ
		 Client client = clientService.getClientByMail(mail);
		 if(client==null) {
			 
			 return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
			 
		 }
		 else {
			 return new ResponseEntity<Client>(client,HttpStatus.OK);
			 
		 }
		 
	 }
}
