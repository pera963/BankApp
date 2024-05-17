package com.bankaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaApp.Model.ATM;
import com.bankaApp.Model.Branch;
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
	
}
