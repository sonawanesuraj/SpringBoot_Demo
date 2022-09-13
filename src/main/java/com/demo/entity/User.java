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

import com.demo.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
@Entity
@Table(name="users")
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE users SET is_active=false WHERE id=?")
//@Projection(name ="User",types= {UserDto.class})
public class User implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id",unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Value("#{target.id}")
	private int id;
	
	@Column(name = "name")
	@Value("#{target.name}")
	private String name;
	
	@Column(name = "mobileNumber")
	@Value("#{target.mobileNumber}")
	private String mobileNumber; 
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "is_active")
	private boolean isActive = true;
	
	
	 
	@Column(name ="created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updatedAt;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "uri.user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<UserRoleEntity> userRole;

	
	
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
		
		}
		
	
	public List<UserRoleEntity> getUserRole() {
		return userRole;
	}
	public void setUserRole(List<UserRoleEntity> userRole) {
		this.userRole = userRole;
	}
	public User() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	
	public User(int id, String name, String mobileNumber, String email, String password, boolean isActive,
			Date createdAt, Date updatedAt, List<UserRoleEntity> userRole) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", password=" + password + ", isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", userRole=" + userRole + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}