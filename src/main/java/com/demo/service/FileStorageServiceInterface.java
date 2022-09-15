package com.demo.service;

import javax.servlet.http.HttpServletRequest;

import com.demo.entity.FileUploadEntity;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageServiceInterface {

	public FileUploadEntity storeFile(MultipartFile file, String type, HttpServletRequest request);

}
