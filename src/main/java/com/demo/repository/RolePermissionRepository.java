package com.demo.repository;

import javax.transaction.Transactional;

import com.demo.entity.RolePermissionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, Integer> {

//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query(value = "UPDATE role permission p SET permission id=:permission_id WHERE u.role_role_id=:role_id",nativeQuery = true)
//	void updateRolePermission(@Param("role_role_id") int role_id,@Param("permission_id") int permission_id);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE role_permission u SET is_active = false WHERE u.role_id=? AND u.permission_id=?", nativeQuery = true)
	void deleteRolePermission(@Param("role_role_id") int role_id, @Param("permisssion_id") int permission_id);

}