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

import com.bankaApp.Model.ATM;
import com.bankaApp.Services.ATMService;

@RestController
@RequestMapping("/api/atm")
public class ATMController {
	
	@Autowired
	private ATMService atmService;
	
	@GetMapping
	public ResponseEntity<List<ATM>> getAllATM(){
		
		List<ATM> atms=atmService.getAllATM();
		  return new ResponseEntity<List<ATM>>(atms,HttpStatus.OK);
		  
	}

	@GetMapping("/{id}")
	public ResponseEntity<ATM> getATMById(@PathVariable int id){
		ATM atm = atmService.getATMById(id);
		if(atm==null) {
			return new ResponseEntity<ATM>(HttpStatus.NOT_FOUND);
			
        }  
        else {
	        return new ResponseEntity<ATM>(atm,HttpStatus.OK);
        }
    }
	
	@GetMapping("/ByName")
	public ResponseEntity<ATM> getATMByName(@RequestParam String name){
		ATM atm = atmService.getATMByName(name);
		if(atm==null) {
			return new ResponseEntity<ATM>(HttpStatus.NOT_FOUND);
		}
		else {
			 return new ResponseEntity<ATM>(atm,HttpStatus.OK);
		}
	}
	
	@GetMapping("/ByBranchAddress")
	public ResponseEntity<List<ATM>> getAllAtmByBranchAddresss(@RequestParam String address){
		List<ATM> atms = atmService.getAllAtmBranchAddress(address);
		return new ResponseEntity<List<ATM>>(atms,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/ByActiveStatusTrue")
	public ResponseEntity<List<ATM>> getAllActiveAtm(){
		List<ATM> atms = atmService.getAllActiveAtm();
		return new ResponseEntity<List<ATM>>(atms,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/ByActiveStatusQuery")
	public ResponseEntity<List<ATM>> getAllActiveAtmByQuery(){
		List<ATM> atms = atmService.getAllActiveATMByQuery();
		return new ResponseEntity<List<ATM>>(atms,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/ByActiveStatusAndBalanceQuery")
	public ResponseEntity<List<ATM>> getAllActiveAtmAndBalanceByQuery(){
		List<ATM> atms = atmService.getAllActiveATMAndBalanceByQuery();
		return new ResponseEntity<List<ATM>>(atms,HttpStatus.OK);
		
		
	}
	
}

