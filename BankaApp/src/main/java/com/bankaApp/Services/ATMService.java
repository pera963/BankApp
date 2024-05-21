package com.bankaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaApp.Model.ATM;
import com.bankaApp.repositories.ATMRepository;

@Service
public class ATMService {

	@Autowired
	private ATMRepository atmRepository;
	
	public List<ATM> getAllATM (){
		List<ATM> atms = atmRepository.findAll();
		return atms;
 	}
	
	public ATM getATMById(int id) {
		ATM atm = atmRepository.findById(id);
		return atm;
	}
	
	public ATM getATMByName(String name) {
		
		ATM atm =atmRepository.findByName(name);
		   return atm;
	}
	
	public List<ATM> getAllAtmBranchAddress (String address){
		List<ATM> atms = atmRepository.findByBranchAddress(address);
		return atms;
		
	}
	public List<ATM> getAllActiveAtm(){
		List<ATM> atms = atmRepository.findByActiveStatusTrue();
		return atms;
		
	}
	
}
