package com.demo.controller;

import java.util.List;

import com.demo.dto.RoleDto;
import com.demo.exception.ErrorResponceDto;
import com.demo.exception.Message;
import com.demo.exception.ResourceNotFoundException;
import com.demo.service.RoleEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private RoleEntityService roleEntityService;
	
	//add all role

	@PostMapping("/role")
	public ResponseEntity<?> addRole(@RequestBody RoleDto roleDto) {
		this.roleEntityService.addRole(roleDto);
		return new ResponseEntity<>(roleDto, HttpStatus.CREATED);
	}

	// get all role
	
	@GetMapping("/role")
	public ResponseEntity<?>getAllroles(){
		try {
		List<RoleDto> findUser=this.roleEntityService.getAllRoles();

			return new ResponseEntity<>(new Message("success", "FoundALLroles", findUser),HttpStatus.OK); 
		}catch(ResourceNotFoundException e) {

			return new ResponseEntity<>(new ErrorResponceDto(e.getMessage(), "NOT FOUND"),HttpStatus.BAD_REQUEST);
		}
		
		}
	
	// get role by id
	
	@GetMapping("/role/{id}")
	public ResponseEntity<?> getByRoleId(@PathVariable Integer id) {
		RoleDto roleDto = this.roleEntityService.getByRoleId(id);

		try {
			

			return new ResponseEntity<>(new Message("Success", "Success", roleDto), HttpStatus.OK);

		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(new ErrorResponceDto(e.getMessage(), "Access Denied"), HttpStatus.BAD_REQUEST);
		}
	}
	
	// update role by id

	@PutMapping("role/{id}")
public ResponseEntity<?>updateRole(@RequestBody RoleDto roleDto,@PathVariable Integer id){
	
	try {
		this.roleEntityService.updateRole(roleDto, id);
		return  new ResponseEntity<>(HttpStatus.OK);
		
	}catch(ResourceNotFoundException e) {
		
		return new ResponseEntity<>(new ErrorResponceDto(e.getMessage(), "Role not found"),HttpStatus.BAD_REQUEST);
	}	
	
}	
	@DeleteMapping("/role/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable Integer id){
		try {
			this.roleEntityService.deleteRole(id);
			return new ResponseEntity<>(new Message("Success","Success","Deleted"),HttpStatus.OK);
		}catch(ResourceNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponceDto(e.getMessage(),"role not found"),HttpStatus.NOT_FOUND);
		}
		
	}
	
	
		
		
		
		
}
	

	
	
