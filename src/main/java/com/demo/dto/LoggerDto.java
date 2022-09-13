package com.demo.dto;

import java.util.Date;

public class LoggerDto {
	
	private int  userId;
	private String token;
	private Date expireAt;
	
	public LoggerDto() {
		
		super();
	}

	public LoggerDto(int userId, String token, Date expireAt) {
		super();
		this.userId = userId;
		this.token = token;
		this.expireAt = expireAt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId){
		userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}
	
	
	
	
}
	

	