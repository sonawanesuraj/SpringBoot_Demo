package com.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "is_active= true")
//@SQLDelete(sql = "UPDATE roles SET is_active=false WHERE role_id=?")
@Table(name = "roles")

public class RoleEntity implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "description")
	private String description;

	@Column(name = "is_active")
	private boolean isActive = true;

	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date updatedAt;

	 @OneToMany(fetch = FetchType.LAZY,mappedBy = "uri.role", cascade = CascadeType.ALL) 
	 @JsonIgnore
	 private List<UserRoleEntity> userRole;

	

	 public List<UserRoleEntity> getUserRole() {
			return userRole;
		}

	public void setUserRole(List<UserRoleEntity> userRole) {
		this.userRole = userRole;
	}

	public int getId() {
		return roleId;
	}

	public void setId(int id) {
		this.roleId = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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



	

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "RoleEntity [roleId=" + roleId + ", roleName=" + roleName + ", description=" + description
				+ ", isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", userRole="
				+ userRole + "]";
	}

	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

public RoleEntity(int roleId, String roleName, String description, boolean isActive, Date createdAt, Date updatedAt,
		List<UserRoleEntity> userRole) {
	super();
	this.roleId = roleId;
	this.roleName = roleName;
	this.description = description;
	this.isActive = isActive;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.userRole = userRole;
}

}
