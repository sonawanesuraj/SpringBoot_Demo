package com.demo.excelhelper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.demo.entity.ExcelFileEntity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Id", "Name", "Address", "Email" };
	static String SHEET = "Sheet1";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {

			return false;
		}

		return true;
	}

	// upload file
	public static List<ExcelFileEntity> excelTodemo(InputStream inputStream) {

		try {
			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet sheet = workbook.getSheet(SHEET);

			Iterator<Row> rows = sheet.iterator();

			List<ExcelFileEntity> demo = new ArrayList<ExcelFileEntity>();

			int rowNumber = 0;
			while (rows.hasNext()) {

				Row currentRow = rows.next();

				if (rowNumber == 0) {

					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				ExcelFileEntity demo1 = new ExcelFileEntity();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {

						case 0:
							demo1.setId((int) (currentCell.getNumericCellValue()));
							break;

						case 1:
							demo1.setName(currentCell.getStringCellValue());
							break;

						case 2:
							demo1.setAddress(currentCell.getStringCellValue());
							break;

						case 3:
							demo1.setEmail(currentCell.getStringCellValue());
							break;
						default:
							break;
					}

					cellIdx++;
				}

				demo.add(demo1);
			}

			workbook.close();

			return demo;
		} catch (Exception e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

	// download file
	public static List<ExcelFileEntity> excelTodemo1(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<ExcelFileEntity> demo = new ArrayList<ExcelFileEntity>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				ExcelFileEntity demo1 = new ExcelFileEntity();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
						case 0:
							demo1.setName(currentCell.getStringCellValue());
							break;

						case 1:
							demo1.setEmail(currentCell.getStringCellValue());
							break;

						case 2:
							demo1.setAddress(currentCell.getStringCellValue());
							break;

						case 3:
							demo1.setId((int) currentCell.getNumericCellValue());
							break;

						default:
							break;
					}

					cellIdx++;
				}

				demo.add(demo1);
			}

			workbook.close();

			return demo;
		} catch (Exception e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

}
