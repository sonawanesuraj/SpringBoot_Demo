package com.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Embeddable
public class UserRoleId implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private User users;
	
	private RoleEntity role;

	public UserRoleId(User user, RoleEntity role) {
		super();
		this.users = user;
		this.role = role;
	}

	public UserRoleId() {
		super();
		//TODO Auto-generated constructor stub
	}
	@ManyToOne
	public User getUser() {
		return users;
	}

	public void setUser(User users) {
		this.users = users;
	}
	@ManyToOne
	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	@Override
	public int hashCode() {

		return Objects.hash(role, users);

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {

			return true;

		}

		if ((obj == null) || (getClass() != obj.getClass())) {

			return false;

		}

		UserRoleId other = (UserRoleId) obj;
		return Objects.equals(role, other.role) && Objects.equals(users, other.users);

	}

	
	
}