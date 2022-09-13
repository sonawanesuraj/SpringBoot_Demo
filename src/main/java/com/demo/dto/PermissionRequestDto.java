package com.demo.dto;

public class PermissionRequestDto {
	
	private String actionName;
	private String baseUrl;
	private String description;
	private String method; 
	private String path;
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public PermissionRequestDto(String actionName, String baseUrl, String description, String method, String path) {
		super();
		this.actionName = actionName;
		this.baseUrl = baseUrl;
		this.description = description;
		this.method = method;
		this.path = path;
	}
	public PermissionRequestDto() {
		super();
		//TODO Auto-generated constructor stub
	}
	

	


}
