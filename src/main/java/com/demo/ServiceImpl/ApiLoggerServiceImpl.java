package com.demo.ServiceImpl;

import com.demo.entity.ApiLoggerEntity;
import com.demo.repository.ApiLoggerRepository;
import com.demo.service.ApiLoggerInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiLoggerServiceImpl implements ApiLoggerInterface {

	@Autowired
	private ApiLoggerRepository apiLoggerRepository;

	public ApiLoggerServiceImpl() {
		super();
	}

	@Override
	public void createApiLog(ApiLoggerEntity api) {
		apiLoggerRepository.save(api);

	}

}
