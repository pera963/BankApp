package com.bankaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaApp.DTOS.ATMDTO;
import com.bankaApp.Model.ATM;
import com.bankaApp.Model.Branch;
import com.bankaApp.Model.Client;
import com.bankaApp.repositories.ATMRepository;
import com.bankaApp.repositories.BranchRepository;

import jakarta.persistence.ManyToOne;

@Service
public class ATMService {

	@Autowired
	private ATMRepository atmRepository;
	@Autowired
	private BranchRepository branchRepository; 
	
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
	
	public List<ATM> getAllActiveATMByQuery(){
		List<ATM> atms = atmRepository.findByActiveStatus();
		return atms;
		
	}
	
	public List<ATM> getAllActiveATMAndBalanceByQuery(){
		List<ATM> atms = atmRepository.findByActiveStatusAndBalance();
		return atms;
		
	}
	public ATM createAtm(ATMDTO atmDTO) {
		Branch branch = branchRepository.findById(atmDTO.getBranch_Id());  // izvlačenje stranog ključa koji je prosleđen
		
		if(branch==null) {
			return null;
		}
		
		ATM atm = new ATM();
		atm.setName(atmDTO.getName());
		atm.setBalance(atmDTO.getBalance());
		atm.setActiveStatus(atmDTO.isActiveStatus());
		atm.setBranch(branch);
		//atm = atmRepository.save(atm);
		//return atm;
		return atmRepository.save(atm);	
			
	}
	
	public ATM updateATM(int id,ATMDTO atmDTO) {
		Branch branch = branchRepository.findById(atmDTO.getBranch_Id());  // izvlačenje stranog ključa koji je prosleđen
		
		if(branch==null) {
			return null;
		}
		
		ATM atm = atmRepository.findById(id);
		
		if(atm==null) {
			return null;
		}
		
		atm.setName(atmDTO.getName());
		atm.setBalance(atmDTO.getBalance());
		atm.setActiveStatus(atmDTO.isActiveStatus());
		atm.setBranch(branch);
		//atm = atmRepository.save(atm);
		//return atm;
		return atmRepository.save(atm);	
			
	}
	
     public ATM deleteATM(int id){
    	
    	ATM atm = atmRepository.findById(id);
        if(atm==null) {
    	   return null;
    	}
        atmRepository.delete(atm);
        return atm;
    }
	
	

}
