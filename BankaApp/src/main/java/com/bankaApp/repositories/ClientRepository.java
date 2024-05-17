package com.bankaApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaApp.Model.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

	Client findByMail(String mail);
	Client findById(int id);
}
