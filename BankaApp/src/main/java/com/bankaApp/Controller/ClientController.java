package com.bankaApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankaApp.DTOS.ClientDTO;
import com.bankaApp.Model.ATM;
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
	 
	 @GetMapping("/{id}")
		public ResponseEntity<Client> getClientById(@PathVariable int id){                     //kada ide samo jedna pretraga po ID onda ide @PathVariable
			Client client = clientService.getClientById(id);
			if(client==null) {
				return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
				
	        }  
	        else {
		        return new ResponseEntity<Client>(client,HttpStatus.OK);
	        }
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

	 @GetMapping("/ByName")
		public ResponseEntity<Client> getClientByName(@RequestParam String name){                     //kada je samo jedana pretraga po nekom drugom parametruide ili više onda ide   (@RequestParamS
			Client client = clientService.getClientByName(name);
			if(client==null) {
				return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
			}
			else {
				 return new ResponseEntity<Client>(client,HttpStatus.OK);
			}
	
	 
	   }

     @GetMapping("/ByNameAndSurname") 
        public ResponseEntity<List<Client>> getClientByNameAndSurname(@RequestParam String name,@RequestParam String surname){
    	     List<Client> clients = clientService.getClientbyNameAndSurname(name, surname);
    	     if(clients.isEmpty()) {
    	    	return new ResponseEntity<List<Client>>(HttpStatus.NOT_FOUND);	 
    	     }
    	     else {
    	    	 return new ResponseEntity<List<Client>>(clients,HttpStatus.OK); 
    	     }  
    	     
    	    
    	 
     }

   //  @GetMapping("/ByMailAndPassword") 
       @GetMapping("/login") 
        public ResponseEntity<Client> getClientByMailAndPassword(@RequestParam String mail,@RequestParam String password){
 	       Client client = clientService.getClientByMailAndPassword(mail, password);
 	       if(client==null) {
 	    	  return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
 	       } 
 	       else {
 	    	  return new ResponseEntity<Client>(client,HttpStatus.OK); 
 	       } 
 	       
 	   }
       
       @PostMapping("/registration")
       public ResponseEntity<Client> registration(@RequestBody ClientDTO clientDto){
    	   Client client =clientService.createClient(clientDto);
    	   if(client==null) {
    		   return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);   
    	   }
    	   else {
    		   return new ResponseEntity<Client>(client,HttpStatus.OK);   
    		   
    	   }
       }




}


