package com.demo.repository;

import com.demo.entity.LoggerEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<LoggerEntity, Integer> {
	
	  LoggerEntity findByToken(String token);

	void removeByToken(String token1);
	  
	  
	

}
