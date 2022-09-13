package com.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
@Entity
@Table(name = "permissions")
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE permissions SET is_active=false WHERE id=?")

public class PermissionEntity  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "action_name")
	private String actionName;
	
	@Column(name = "discription")
	private String discription;
	
	@Column(name = "method")
	private String method;
	
	@Column(name = "baseUrl")
	private String baseUrl;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "is_active")
	private boolean isActive= true;
	
	@Column(name = "created_At")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "updated_At")
	@UpdateTimestamp
	private Date updatedAt;
	
	public PermissionEntity() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public PermissionEntity(int id, String actionName, String discription, String method, String baseUrl, String path,
			boolean isActive, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.actionName = actionName;
		this.discription = discription;
		this.method = method;
		this.baseUrl = baseUrl;
		this.path = path;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	
}
