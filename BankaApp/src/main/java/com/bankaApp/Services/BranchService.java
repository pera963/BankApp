package com.bankaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaApp.DTOS.BranchDTO;
import com.bankaApp.Model.ATM;
import com.bankaApp.Model.Branch;
import com.bankaApp.Model.Client;
import com.bankaApp.repositories.BranchRepository;

@Service
public class BranchService {
	
	@Autowired
	private BranchRepository branchRepository;

	public List<Branch> getAllBranch (){
		List<Branch> branch = branchRepository.findAll();
		return branch;
 	}
	
	public Branch getBranchById(int id) {
		Branch branch = branchRepository.findById(id);
		return branch;
	}
	 public Branch getBranchByName(String name) {
			
			Branch branch = branchRepository.findByName(name);
			   return branch;
		}
	 
	 public Branch createBranch(BranchDTO branchDTO ) {
		   Branch branch = new Branch();
		   branch.setName(branchDTO.getName());
		   branch.setAddress(branchDTO.getAddress());
		   branch.setCity(branchDTO.getCity());
		   branch.setPhoneNumber(branchDTO.getPhoneNumber());
		   return branchRepository.save(branch);
	 }
	 
	 public Branch updateBranch(int id, BranchDTO branchDTO) {
		   Branch branch = branchRepository.findById(id);
		   if(branch==null) {
			   return null;
		   }
		   branch.setName(branchDTO.getName());
		   branch.setAddress(branchDTO.getAddress());
		   branch.setCity(branchDTO.getCity());
		   branch.setPhoneNumber(branchDTO.getPhoneNumber());
		   return branchRepository.save(branch);
	 }
}
