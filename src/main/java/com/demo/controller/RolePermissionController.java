package com.demo.controller;

import java.util.List;

import com.demo.dto.RolePermissionDto;
import com.demo.entity.RolePermissionEntity;
import com.demo.exception.ErrorResponceDto;
import com.demo.service.RolePermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolePermissionController {
	
	@Autowired 
	private RolePermissionService rolePermissionService;
	
	@PostMapping("/assignPermission")
	public ResponseEntity<?> addPermissionToRole(@RequestBody RolePermissionDto dto){
		try {
		this.rolePermissionService.addPermissionToRole(dto);
		return ResponseEntity.ok("Permission Assign Successfully");
	}catch(Exception e)
		{
		return new ResponseEntity<>(new ErrorResponceDto("User Alrready Exist","insert another permission"),HttpStatus.OK);
		}
	
	}
	
	@GetMapping("/roleAndPermission")
	public List<RolePermissionEntity> getAllRolePermission(){
		return this.rolePermissionService.getAllRolePermission();
		
	}
	
	
	

}
