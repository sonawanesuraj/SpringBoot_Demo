package com.demo.entity;

import java.io.Serializable;
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
@Table(name="user_role")
@AssociationOverrides({ @AssociationOverride(name = "uri.users", joinColumns = @JoinColumn(name = "user_id")), @AssociationOverride(name = "uri.roles", joinColumns = @JoinColumn(name = "role_id")) })
public class UserRoleEntity implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRoleId uri= new UserRoleId();
	
	@Column(name="is_Active")
	private boolean isActive = true;

	@CreationTimestamp
	private Date createdAt;

	
	@UpdateTimestamp
	private Date updatedAt;
   @EmbeddedId
	public UserRoleId getUri() {
		return uri;
	}

	public void setUri(UserRoleId uri) {
		this.uri = uri;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@CreationTimestamp
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	  @UpdateTimestamp
	public Date getUpdatedAt() {
		return updatedAt;
	}
   
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "UserRoleEntity [uri=" + uri + ", isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
	
	

}
