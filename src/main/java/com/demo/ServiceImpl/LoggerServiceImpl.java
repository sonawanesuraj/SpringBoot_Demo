package com.demo.ServiceImpl;

import com.demo.dto.LoggerDto;
import com.demo.entity.LoggerEntity;
import com.demo.entity.User;
import com.demo.repository.LoggerRepository;
import com.demo.service.LoggerServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoggerServiceImpl implements LoggerServiceInterface {
	
	@Autowired
	private LoggerRepository loggerRepository;

	public LoggerEntity createLogger(LoggerDto loggerDto,User user) {
		
		LoggerEntity logger = new LoggerEntity();
		logger.setUserId(user);
		logger.setToken(loggerDto.getToken());
		logger.setCreatedAt(loggerDto.getExpireAt());
		logger.setExpireAt(loggerDto.getExpireAt());
		return loggerRepository.save(logger);	
		
	}

	@Override
	public void logout(String token) {
		final String token1=token.substring(7);
		loggerRepository.removeByToken(token1);
		
	}

	@Override
	public LoggerEntity getLoggerDetail(String token) {	
		LoggerEntity loggerEntity;
	loggerEntity = this.loggerRepository.findByToken(token);
		return loggerEntity;
	}
	

}

