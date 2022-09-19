package com.demo.service;

import java.util.List;

import com.demo.entity.ExcelFileEntity;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelFileInterface {

	void addExcelFile(MultipartFile multipartfile);

	List<ExcelFileEntity> getAllExcelFileData();

}
