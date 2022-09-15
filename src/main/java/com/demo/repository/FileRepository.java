package com.demo.repository;

import com.demo.entity.FileUploadEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileUploadEntity, Integer> {

}
