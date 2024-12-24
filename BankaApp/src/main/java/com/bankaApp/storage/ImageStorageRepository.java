package com.bankaApp.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageStorageRepository extends JpaRepository<ImageStorage, Integer>{
	ImageStorage findByName(String name);

}
