package com.bankaApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaApp.Model.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

	Admin findByMailAndPassword(String mail,String password);
}
