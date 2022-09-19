package com.demo.controller;

import java.util.List;

import com.demo.entity.ExcelFileEntity;
import com.demo.excelhelper.ExcelHelper;
import com.demo.exception.ErrorResponceDto;
import com.demo.service.ExcelFileInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelFileController {

	@Autowired
	private ExcelFileInterface excelFileInterface;

	@PostMapping("uploadExcel-file")
	public ResponseEntity<?> uploadExcelFile(@RequestParam("file") MultipartFile multipartFile) {

		if (ExcelHelper.hasExcelFormat(multipartFile)) {
			try {
				excelFileInterface.addExcelFile(multipartFile);

				return new ResponseEntity<>("Excel file Successfully uploaded", HttpStatus.OK);

			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponceDto(e.getMessage(), "could not upload the file"),
						HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>("please upload an Excel file", HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/download")
	public ResponseEntity<List<ExcelFileEntity>> getAllTutorials() {
		try {
			List<ExcelFileEntity> excelFileData = excelFileInterface.getAllExcelFileData();

			if (excelFileData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(excelFileData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
