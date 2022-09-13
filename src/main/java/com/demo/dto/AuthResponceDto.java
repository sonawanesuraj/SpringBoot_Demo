package com.demo.dto;

import java.io.Serializable;

public class AuthResponceDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  String jwtToken ;

	private String email;

	private String name;

	private int id;
	
	
 
	public AuthResponceDto(String jwtToken, String email, String name, int id) {
		super();
		this.jwtToken = jwtToken;
		this.email = email;
		this.name = name;
		this.id = id;
	}

	 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJwtToken() {
		return jwtToken;
	}


	public AuthResponceDto() {
		super();
		
	}
	
	


}
