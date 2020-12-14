package com.export.data.controller;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.export.data.entity.Student;
import com.export.data.service.IStudentService;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Sep 5, 2020	
 *@version 1.0
 */
@RestController
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@GetMapping("/export")
	public String exportToCSV() throws IOException {

		List<Student> students = studentService.findAll();

		Writer writer = new FileWriter("D:\\FULL JAVA\\Java\\aaa.csv");

		ICsvBeanWriter csvWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "Roll No", "Full Name", "Gender" };
		String[] nameMapping = { "rollno", "fullname", "gender" };

		csvWriter.writeHeader(csvHeader);

		for (Student student : students) {
			csvWriter.write(student, nameMapping);
		}

		csvWriter.close();

		return "OK";
	}

	private static String[] columns = { "Roll No", "Name", "Date Of Birth", "Address", "Gender" };

	@GetMapping("/export_data")
	public String exportToExcel() throws IOException {

		List<Student> students = studentService.findAll();

		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Employee");

		writeHeaderLine(sheet, columns);
		writeDataLines(workbook, students, sheet);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("D:\\FULL JAVA\\Java\\aaabbbb.xlsx");
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();

		return "OK";
	}

	private void writeDataLines(Workbook workbook, List<Student> students, Sheet sheet) {
		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		CreationHelper createHelper = workbook.getCreationHelper();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (Student employee : students) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(employee.getRollno());

			row.createCell(1).setCellValue(employee.getFullname());

			Cell dateOfBirthCell = row.createCell(2);
			dateOfBirthCell.setCellValue(employee.getBirthday());
			dateOfBirthCell.setCellStyle(dateCellStyle);

			row.createCell(3).setCellValue(employee.getAddress());

			row.createCell(4).setCellValue(employee.getGender());
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	private void writeHeaderLine(Sheet sheet, String[] columns2) {
		// Create a Row
		Row headerRow = sheet.createRow(0);
		// Create cells
		for (int i = 0; i < columns2.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns2[i]);
		}
	}
}
