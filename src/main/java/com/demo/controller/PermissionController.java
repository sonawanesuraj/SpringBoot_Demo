package com.demo.controller;

import java.util.List;

import com.demo.dto.PermissionRequestDto;
import com.demo.entity.PermissionEntity;
import com.demo.exception.ErrorResponceDto;
import com.demo.exception.Message;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.PermissionRepository;
import com.demo.service.PermissionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PermissionController {
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private PermissionEntityService permissionEntityService;
	
	// Add Permission	
	@PostMapping("/permission")
	public ResponseEntity<?> addPermissions(@RequestBody PermissionRequestDto permissionRequestDto){		
	this.permissionEntityService.addPermission(permissionRequestDto);
	return new ResponseEntity<>(HttpStatus.CREATED);
	
	}	
	
	  // get all permission
	
	@GetMapping("/permission")
	public ResponseEntity<?> getAllPermissions(){
		List<PermissionEntity> list = this.permissionEntityService.getAllPermissions();
		
		return ResponseEntity.ok(new Message("All Permission","Permission and Role", list));
				
	}
	
	// get permission by id
	
	@GetMapping("/permission/{id}")
	public ResponseEntity<?> getPermissionById(@PathVariable("id") int id){
		
	 PermissionEntity entity=this.permissionEntityService.getPermissionById(id);
		
		return new ResponseEntity<>(new Message("Permission", "permission id", entity),HttpStatus.ACCEPTED);
	}
	
   // update permission
	
	@PutMapping("/permission/{id}")
	public ResponseEntity<?> updatePermission(@PathVariable("id")int id,@RequestBody PermissionRequestDto permissionRequestDto) throws ResourceNotFoundException{
		try {
		PermissionEntity entity = this.permissionEntityService.updatePermission(permissionRequestDto, id);
		return new ResponseEntity<>(new Message("Success","Success", entity),HttpStatus.OK) ;
	}catch(ResourceNotFoundException e)
		{
		return new ResponseEntity<>(new ErrorResponceDto(e.getMessage(), "Permission Not Found..!!"),HttpStatus.NOT_FOUND);
		}
	}
	
	// delete permission
	@DeleteMapping("/permission/{id}")
	public void deletePermission(@PathVariable("id")int id) {
		permissionEntityService.deletePermission(id);
		
	}
	
	
}
