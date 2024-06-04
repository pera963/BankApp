package com.bankaApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankaApp.Model.Admin;
import com.bankaApp.Services.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/login") 
    public ResponseEntity<Admin> getAdminByMailAndPassword(@RequestParam String mail,@RequestParam String password){
	       Admin admin = adminService.getAdminByMailAndPassword(mail, password);
	       if(admin==null) {
	    	  return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
	       } 
	       else {
	    	  return new ResponseEntity<Admin>(admin,HttpStatus.OK); 
	       } 
	       
	   }

}
