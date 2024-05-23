package com.bankaApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankaApp.Model.ATM;

@Repository 
public interface ATMRepository extends JpaRepository<ATM,Integer> {

	ATM findById(int id);
	ATM findByName(String name);
	List<ATM> findByBranchAddress(String address);
	
	List<ATM> findByActiveStatusTrue();
	
	@Query("SELECT a FROM ATM a WHERE a.activeStatus = TRUE  ")
	List<ATM> findByActiveStatus();
	
	@Query("SELECT a FROM ATM a WHERE a.activeStatus = TRUE AND a.balance > 1000000 ")
	List<ATM> findByActiveStatusAndBalance();
	
	
}


