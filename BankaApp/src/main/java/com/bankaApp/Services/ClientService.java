package com.bankaApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Client getClientByMail(String mail) {
		
		Client client = clientRepository.findByMail(mail);
		    return client;
	}

}
