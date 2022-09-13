package com.demo.entity;

public class AssignRole {
	private int roleId;
	private int userId;
	public AssignRole() {
		super();
		//TODO Auto-generated constructor stub
	}
	public AssignRole(int roleId, int userId) {
		super();
		this.roleId = roleId;
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	

}
