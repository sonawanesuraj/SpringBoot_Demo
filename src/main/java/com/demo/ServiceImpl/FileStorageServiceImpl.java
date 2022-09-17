package com.demo.ServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import com.demo.entity.FileUploadEntity;
import com.demo.exception.FileStorageException;
import com.demo.exception.ResourceNotFoundException;
import com.demo.properties.FileStorageProperties;
import com.demo.repository.FileUploadRepository;
import com.demo.service.FileStorageServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageServiceInterface {

	private final Path fileStorageLocation;

//	@Autowired
	public FileStorageServiceImpl(FileStorageProperties fileStorageProperties) {

		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {

			Files.createDirectories(this.fileStorageLocation);

		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);
		}

	}

	@Autowired
	private FileUploadRepository fileUploadRepository;

	@Override
	public FileUploadEntity storeFile(MultipartFile file, String type, HttpServletRequest request) {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (fileName.contains("..")) {
				throw new FileStorageException("Sory...! FileName contains Invalid Path sequence " + fileName);
			}

			File pathASFile = new File(this.fileStorageLocation + "/" + type);

			if (!Files.exists(Paths.get(this.fileStorageLocation + "/" + type))) {

				pathASFile.mkdir();
			}

			Path targetLocation = this.fileStorageLocation.resolve(type + "/" + fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			FileUploadEntity fileUploadEntity = new FileUploadEntity();
			fileUploadEntity.setEncoding(request.getCharacterEncoding());
			fileUploadEntity.setType(type);
			fileUploadEntity.setFilename(fileName);
			fileUploadEntity.setMimetype(file.getContentType());
			fileUploadEntity.setSize(file.getSize());
			fileUploadEntity.setOriginalName(fileName);
			FileUploadEntity fileDetails = fileUploadRepository.save(fileUploadEntity);

			return fileDetails;

		} catch (IOException ex) {

			throw new FileStorageException(" could not store file " + fileName + " .please try again..!", ex);
		}

	}

	@Override
	public Resource loadFileAsResource(String fileName) throws FileNotFoundException {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());

			if (resource.exists()) {

				return resource;
			} else {
				throw new FileNotFoundException("File Not Found");
			}

		} catch (MalformedURLException ex) {

			throw new FileNotFoundException("File Not Found");

		}

	}

	@Override
	public String getFolderName(String type) throws ResourceNotFoundException {
		String folderPath = "";

		switch (type) {

			case "images":
				folderPath = "images";
				break;

			case "test":
				folderPath = "test";
				break;

			case "pdf":
				folderPath = "pdf";
				break;

			default:
				throw new ResourceNotFoundException("Invalid Upload Type");

		}
		return folderPath;
	}

}
