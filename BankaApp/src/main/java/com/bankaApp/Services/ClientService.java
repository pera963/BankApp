package com.bankaApp.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaApp.DTOS.ClientDTO;
import com.bankaApp.Model.ATM;
import com.bankaApp.Model.Branch;
import com.bankaApp.Model.Client;
import com.bankaApp.Model.EmailToken;
import com.bankaApp.repositories.ClientRepository;
import com.bankaApp.repositories.EmailTokenRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private EmailTokenRepository emailTokenRepository;
	
	@Autowired
    private EmailService emailService;
	
	
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
    	if (client.isStatus()==false) {
    		return null;
    	}
    	return client;
    }
    
    public Client createClient(ClientDTO clientDto) {
    	Client client = new Client(clientDto.getName(),clientDto.getSurname(),clientDto.getMail(),clientDto.getAddress(),
    			clientDto.getPhoneNumber(),clientDto.getUserName(),clientDto.getPassword(),false);
    	String token=UUID.randomUUID().toString();
    	EmailToken emailToken=new EmailToken(token,LocalDateTime.now(),LocalDateTime.now().plusMinutes(30),client);
    	emailTokenRepository.save(emailToken);
    	String link="http://localhost:8080/api/client/confirm?token="+token;
    	
    	String body = "<html><body style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;'>"
		        + "<div style='background-color: #ffffff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);'>"
		        + "<h1 style='color: #333;'>Poštovani,</h1>"
		        + "<p style='color: #555;'>Uspešno ste se registrovali!</p>"
		        + "<p style='color: #555;'>Hvala vam što ste se pridružili našoj aplikaciji.</p>"
		        + "<p style='color: #555;'>Da biste potvrdili vašu registraciju, kliknite na <a href='" + link + "' style='color: #1a73e8;'>ovaj link</a>.</p>"
		        + "</div></body></html>";
	   emailService.sendEmail(client.getMail()," Potvrda registracije" , body);
    	return clientRepository.save(client);
    }
    public Client updateClient(int id,ClientDTO clientDTO) {
    	Client client= clientRepository.findById(id);
    	if(client==null) {
    		return null;
    	}
    	client.setName(clientDTO.getName());
    	client.setSurname(clientDTO.getSurname());
    	client.setMail(clientDTO.getMail());
    	client.setAddress(clientDTO.getAddress());
    	client.setPhoneNumber(clientDTO.getPhoneNumber());
    	client.setUserName(clientDTO.getUserName());
    	client.setPassword(clientDTO.getPassword());
    	return clientRepository.save(client);
    }
    
    public Client deleteClient(int id){
    	
    	Client client = clientRepository.findById(id);
        if(client==null) {
    	   return null;
    	}
        clientRepository.delete(client);
        return client;
    }

	public String confirmEmail(String token) {
		EmailToken emailToken=emailTokenRepository.findByToken(token);
		if(emailToken==null) {
			throw new IllegalStateException("Token nije validan");
		}
		if(emailToken.getConfirmationDate()!=null) {
			throw new IllegalStateException("E-mail je već potvrđen");
		}
		if(emailToken.getExpirationDate().isBefore(LocalDateTime.now())) {
			throw new IllegalStateException("Token je istekao");
		}
		Client client=emailToken.getClient();
		client.setStatus(true);
		emailToken.setConfirmationDate(LocalDateTime.now());
		emailTokenRepository.save(emailToken);
		clientRepository.save(client);
		return "Uspešno ste potvrdili  vaš E-mail";
	}
         

}
