package com.demo.dto;

public class UserRoleDto {
	
	private String email ;
	private String role;
	
	public UserRoleDto() {
		super();
		//TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserRoleDto(String email, String role) {
		super();
		this.email = email;
		this.role = role;
	}
	
	

	
	
	

}
