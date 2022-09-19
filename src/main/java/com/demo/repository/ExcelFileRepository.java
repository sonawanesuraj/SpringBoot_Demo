package com.demo.repository;

import com.demo.entity.ExcelFileEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelFileRepository extends JpaRepository<ExcelFileEntity, Integer> {

}
