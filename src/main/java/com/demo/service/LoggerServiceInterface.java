package com.demo.service;

import com.demo.dto.LoggerDto;
import com.demo.entity.LoggerEntity;
import com.demo.entity.User;

public interface LoggerServiceInterface {
	
	LoggerEntity createLogger(LoggerDto loggerDto,User user);
	LoggerEntity getLoggerDetail(String token);

	
	void logout(String token);
	
	

}
