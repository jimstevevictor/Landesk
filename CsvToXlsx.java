package com.spring.boot.landesk.auto.main;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Path;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CsvToXlsx {

	public static void convert(Path path1) {
		// TODO Auto-generated method stub

		try {
//			String csvFileAddress = "csv.csv"; // csv file address
			String xlsxFileAddress = "D:\\\\workspace\\\\convertedToExcel.xls"; // xlsx file address
			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("sheet1");
			String currentLine = null;
			int RowNum = 0;
			BufferedReader br = new BufferedReader(new FileReader(path1.toString()));
			while ((currentLine = br.readLine()) != null) {
				String str[] = currentLine.split(",");
				RowNum++;
				XSSFRow currentRow = sheet.createRow(RowNum);
				for (int i = 0; i < str.length; i++) {
					currentRow.createCell(i).setCellValue(str[i]);
				}
			}

			FileOutputStream fileOutputStream = new FileOutputStream(xlsxFileAddress);
			workBook.write(fileOutputStream);
			fileOutputStream.close();
			System.out.println("Done");
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + "Exception in try");
		}

	}

}
