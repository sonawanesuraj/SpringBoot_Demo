package com.demo.ServiceImpl;

import java.util.List;

import com.demo.entity.ExcelFileEntity;
import com.demo.excelhelper.ExcelHelper;
import com.demo.repository.ExcelFileRepository;
import com.demo.service.ExcelFileInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelFileServiceImpl implements ExcelFileInterface {

	@Autowired
	private ExcelFileRepository excelFileRepository;

	@Override
	public void addExcelFile(MultipartFile multipartfile) {
		try {
			List<ExcelFileEntity> demo1 = ExcelHelper.excelTodemo(multipartfile.getInputStream());
			excelFileRepository.saveAll(demo1);

		} catch (Exception e) {

			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
		return;

	}

	@Override
	public List<ExcelFileEntity> getAllExcelFileData() {

		List<ExcelFileEntity> excelFileData = excelFileRepository.findAll();

		return excelFileData;

	}

}
