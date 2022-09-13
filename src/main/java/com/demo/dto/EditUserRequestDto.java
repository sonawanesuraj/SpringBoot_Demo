package com.demo.dto;

public class EditUserRequestDto {
	
	private int role;

	public EditUserRequestDto() {
		super();
		//TODO Auto-generated constructor stub
	}

	public EditUserRequestDto(int role) {
		super();
		this.role = role;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	

}
