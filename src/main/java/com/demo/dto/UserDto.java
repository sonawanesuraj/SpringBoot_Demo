package com.demo.dto;

import javax.validation.constraints.Email;




public class UserDto {  

	
	private int id;
	

	private String name;
	

	private String mobileNumber;
	
	@Email(message="Email is not valid !!")
	private String email;
	
	///@JsonProperty(access =JsonProperty.Access.READ_WRITE)
	//@Size(min = 4,max = 10,message = "password min of 3 chars and max of 10 chars !! ")
	private String password;
	
	
	
	public UserDto() {
		super();
		//TODO Auto-generated constructor stub
	}

	
	

	
	

	public UserDto(int id,String name, String mobileNumber, @Email(message = "Email is not valid !!") String email,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	
	}







	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	


	

	
	
	

}
