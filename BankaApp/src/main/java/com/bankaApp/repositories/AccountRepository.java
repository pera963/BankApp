package com.bankaApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaApp.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

	Account findById(int id);
}
