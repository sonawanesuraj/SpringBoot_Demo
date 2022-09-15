package com.demo.ServiceImpl;

import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;

import com.demo.entity.FileUploadEntity;
import com.demo.service.FileStorageServiceInterface;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageServiceInterface {
	private final Path fileStorageLocation;

	@Override
	public FileUploadEntity storeFile(MultipartFile file, String type, HttpServletRequest request) {

		return null;
	}

}
