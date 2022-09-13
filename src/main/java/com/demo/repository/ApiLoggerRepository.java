package com.demo.repository;

import com.demo.entity.ApiLoggerEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiLoggerRepository  extends JpaRepository<ApiLoggerEntity, Integer>{
	

}
