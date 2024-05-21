package com.bankaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaApp.Model.ATM;
import com.bankaApp.Model.Branch;
import com.bankaApp.Model.Client;
import com.bankaApp.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAllClient (){
		List<Client> client = clientRepository.findAll();
		return client;
 	}
	
	public Client getClientById(int id) {
		Client client = clientRepository.findById(id);
		return client;
	}
	
	
	
	public Client getClientByMail(String mail) {
		
		Client client = clientRepository.findByMail(mail);
		    return client;
	}
   
    public Client getClientByName(String name) {
		
		Client client =clientRepository.findByName(name);
		   return client;
	}
	
    public List<Client> getClientbyNameAndSurname(String name,String surname) {
    	
    	List<Client> client = clientRepository.findByNameAndSurname(name, surname);
    	return client;
    }
	
    public Client getClientByMailAndPassword(String mail,String password) {
    	
    	Client client = clientRepository.findByMailAndPassword(mail, password);
    	return client;
    }


}
