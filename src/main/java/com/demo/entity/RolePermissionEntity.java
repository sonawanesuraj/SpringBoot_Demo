package com.demo.entity;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name ="Role_Permissions")
@AssociationOverrides({ @AssociationOverride(name = "pk.roles", joinColumns = @JoinColumn(name = "role_id")), @AssociationOverride(name = "pk.permissions", joinColumns = @JoinColumn(name = "permission_id")) })
public class RolePermissionEntity {
	
	@EmbeddedId
	private RolePermissionId pk = new RolePermissionId(); 	
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;

	public RolePermissionId getPk() {
		return pk;
	}

	public void setPk(RolePermissionId pk) {
		this.pk = pk;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
    @Column(name = "created_At")
    @CreationTimestamp
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
    @Column(name = "updated_At")
    @UpdateTimestamp
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public RolePermissionEntity(RolePermissionId pk, boolean isActive, Date createdAt, Date updatedAt) {
		super();
		this.pk = pk;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public RolePermissionEntity() {
		super();
	}
	
	
	
	
	
	

}
