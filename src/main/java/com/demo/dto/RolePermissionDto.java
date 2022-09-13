package com.demo.dto;

public class RolePermissionDto {
	
	private int  roleId;
	private int  permissionId;
	
	
	public RolePermissionDto() {
		super();
		//TODO Auto-generated constructor stub
	}


	public RolePermissionDto(int roleId, int permissionId) {
		super();
		this.roleId = roleId;
		this.permissionId = permissionId;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public int getPermissionId() {
		return permissionId;
	}


	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	
	
	
	
	

}
