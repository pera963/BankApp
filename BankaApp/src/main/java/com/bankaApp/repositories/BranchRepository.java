package com.bankaApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaApp.Model.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {

	Branch findById(int id);
}
