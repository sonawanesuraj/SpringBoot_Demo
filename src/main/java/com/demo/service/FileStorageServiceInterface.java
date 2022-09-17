package com.demo.service;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import com.demo.entity.FileUploadEntity;
import com.demo.exception.ResourceNotFoundException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageServiceInterface {

	public FileUploadEntity storeFile(MultipartFile file, String type, HttpServletRequest request);

	public Resource loadFileAsResource(String fileName) throws FileNotFoundException;

	public String getFolderName(String type) throws ResourceNotFoundException;

}
