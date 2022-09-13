package com.demo.repository;

import javax.transaction.Transactional;

import com.demo.entity.UserRoleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Transactional
@Repository
 public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer>{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value ="UPDATE user_role u SET active=false WHERE u.role_role_id=:role_role_id AND u.user_id=:user_id",nativeQuery = true)
	void deleteRole(@Param("role_role_id")int role_id,@Param("user_id")int user_id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE user_role u SET role_role_id=:role_role_id WHERE u.user_id=:user_id",nativeQuery = true)
	void updateUserRole(@Param("role_role_id") int role_id,@Param("user_id") int user_id);
	
	
	
}
