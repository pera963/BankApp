package com.bankaApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankaApp.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

	Account findById(int id);
	
	List<Account> findByClientMail (String mail);
	
	@Query("SELECT a FROM Account a WHERE a.accountType='Dev'")
	List<Account> findByAccountType();
	
}
