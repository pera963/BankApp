package com.bankaApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaApp.Model.EmailToken;

@Repository
public interface EmailTokenRepository extends JpaRepository<EmailToken, Integer>{
   EmailToken findByToken(String token);
}
