package com.demo.service;

import java.util.List;

import com.demo.dto.PermissionRequestDto;
import com.demo.entity.PermissionEntity;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.PermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class PermissionEntityService  {

	@Autowired
	private PermissionRepository permissionRepository;

	
	public void addPermission(PermissionRequestDto permissionRequestDto) {

		PermissionEntity permissionEntity = new PermissionEntity();
		System.out.println(permissionEntity + "tttt");
		permissionEntity.setActionName(permissionRequestDto.getActionName());
		permissionEntity.setBaseUrl(permissionRequestDto.getBaseUrl());
		permissionEntity.setDiscription(permissionRequestDto.getDescription());
		permissionEntity.setMethod(permissionRequestDto.getMethod());
		permissionEntity.setPath(permissionRequestDto.getPath());

		this.permissionRepository.save(permissionEntity);

		return;

	}

	// get all permission

	public List<PermissionEntity> getAllPermissions() {
		List<PermissionEntity> list = this.permissionRepository.findAll();
		// TODO Auto-generated method stub
		return list;
	}

	
	// get permission by id
	public PermissionEntity getPermissionById(int id) {

		PermissionEntity entity = this.permissionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id Not Found , Please insert correct Id"));

		this.permissionRepository.save(entity);

		return entity;
	}
	
	 // update permission by id
	
	public PermissionEntity updatePermission(PermissionRequestDto permissionRequestDto,int  id)throws ResourceNotFoundException {
		
		PermissionEntity entity = this.permissionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Resourse Not Found"));
		entity.setActionName(permissionRequestDto.getActionName());
		entity.setDiscription(permissionRequestDto.getDescription());
		entity.setBaseUrl(permissionRequestDto.getBaseUrl());
		entity.setMethod(permissionRequestDto.getMethod());
		entity.setPath(permissionRequestDto.getPath());
		return this.permissionRepository.save(entity);
		
	}
	// delete permission by id

	public void deletePermission(Integer id) {
		permissionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id not found"));
		permissionRepository.deleteById(id);
	}
	
	
	
	
	

}
