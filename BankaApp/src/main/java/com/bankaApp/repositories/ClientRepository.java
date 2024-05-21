package com.bankaApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaApp.Model.ATM;
import com.bankaApp.Model.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

	Client findByMail(String mail);
	Client findById(int id);
	Client findByName(String name);
    Client findBySurname(String surname );
    
    List<Client> findByNameAndSurname(String name,String surname);
    Client findByMailAndPassword(String mail,String password);

}


