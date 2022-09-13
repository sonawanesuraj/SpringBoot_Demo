package com.demo.controller;

import java.util.List;

import com.demo.dto.UserRoleDto;
import com.demo.entity.AssignRole;
import com.demo.entity.UserRoleEntity;
import com.demo.exception.ErrorDetails;
import com.demo.exception.ErrorResponceDto;
import com.demo.service.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {
	
	@Autowired
	private UserRoleService userRoleService;
	
	//  add all role to user 
	
	@PostMapping("/assignRole")
	public ResponseEntity<?> asignRole(UserRoleDto userRoleDto ){
		
	this.userRoleService.addRolesToUser(userRoleDto);
		
		return ResponseEntity.ok("Role Assign Succefully");
		
	}
	
	
	// get all user and roles
	
		@GetMapping("/userAndRole")
		public List<UserRoleEntity> getAllUserAndRole(){
			return this.userRoleService.getAllUserRole();
		
			
		}
		
		// update user by its role
		
		@PutMapping("/userRole")
		public ResponseEntity<?> updateRole(@RequestBody AssignRole userRoleDto){
			this.userRoleService.updateRole(userRoleDto);
			return  ResponseEntity.ok("update Successfully");
			
			
		}
		
		 @DeleteMapping("/userRole")
		 public ResponseEntity<?>deleteRole(@RequestBody UserRoleDto userRoleDto){
			 this.userRoleService.deleteRole(userRoleDto);	 
			return ResponseEntity.ok("Delete Role Successfully");
					 
		 }
		
	}
	
	
	

