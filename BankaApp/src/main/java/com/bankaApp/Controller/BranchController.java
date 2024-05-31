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

import com.bankaApp.DTOS.BranchDTO;
import com.bankaApp.Model.ATM;
import com.bankaApp.Model.Branch;
import com.bankaApp.Services.BranchService;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	 @GetMapping
	    public ResponseEntity<List<Branch>> getAllBranch(){
	    	
	    	List<Branch> branch=branchService.getAllBranch();
	    	  return new ResponseEntity<List<Branch>>(branch,HttpStatus.OK);
	    }
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Branch> getBranchById(@PathVariable int id){       // @PathVariable - pokupi iz putanje id,koji 'emo mi proslediti u servis
	    	Branch branch = branchService.getBranchById(id);
	    	if(branch==null) {
	    	return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);            // ResponseEntity<Account> response = new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	    	                                                                    //  return response;
	    	             
	    	}
	    	else {
	    		return new ResponseEntity<Branch>(branch,HttpStatus.OK);
	    	}
	    }

	 @GetMapping("/ByName")//za izvlačenje podataka
		public ResponseEntity<Branch> getBranchByName(@RequestParam String name){
			Branch branch = branchService.getBranchByName(name);
			if(branch==null) {
				return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);
			}
			else {
				 return new ResponseEntity<Branch>(branch,HttpStatus.OK);
			}
		}
	 
	 @PostMapping   // za kreiranje podataka
	 public ResponseEntity<Branch> createBranch(@RequestBody BranchDTO branchDTO){
		   Branch branch = branchService.createBranch(branchDTO);
		   if(branch ==null) {
			   return new ResponseEntity<Branch>(HttpStatus.BAD_REQUEST);
			   
		   }
		   else {
			   return new ResponseEntity<Branch>(branch,HttpStatus.OK);
		   }
	 }


}









