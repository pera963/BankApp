package com.bankaApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaApp.Model.ATM;

@Repository 
public interface ATMRepository extends JpaRepository<ATM,Integer> {

	ATM findById(int id);
	ATM findByName(String name);
	List<ATM> findByBranchAddress(String address);
	
	List<ATM> findByActiveStatusTrue();
}
