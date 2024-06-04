package com.bankaApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaApp.Model.Admin;

import com.bankaApp.repositories.AdminRepository;

@Service
public class AdminService {

	
	@Autowired
	private AdminRepository adminRepository;
	
    public Admin getAdminByMailAndPassword(String mail,String password) {
    	
    	Admin admin = adminRepository.findByMailAndPassword(mail, password);
    	
    	return admin;
    }
}
