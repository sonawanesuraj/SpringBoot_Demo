package com.demo.repository;



import com.demo.entity.PermissionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer > {

	
//	PermissionEntity findByPermissionId(int  id);

}
