package com.demo.repository;



import com.demo.entity.RoleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {

	
	
@Query("SELECT r FROM  RoleEntity r WHERE r.roleName =:roleName")
	public RoleEntity findByName(String roleName);
	//public RoleEntity findByroleName(RoleEntity roleName);




	
	
	
	
	
	
	
	

}
