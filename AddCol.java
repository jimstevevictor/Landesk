package com.spring.boot.landesk.auto.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.spring.boot.landesk.auto.dao.CoreApps;

public class AddCol {

	public static ArrayList<String> readExcel(String filepath) {
		ArrayList<String> rowDataList = new ArrayList<String>();
		try {

			FileInputStream file = new FileInputStream(new File(filepath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			boolean isFirstIter = true;
			List<String> colHeaders = new ArrayList<>();
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.iterator();
				if (isFirstIter) {
					setHeaders(cellIterator, colHeaders);
					isFirstIter = false;
				} else {
					setRows(cellIterator, rowDataList);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowDataList;
	}

	private static void setRows(Iterator<Cell> cellIterator, ArrayList<String> rowDataList) {
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
					rowDataList.add(dateformat.format(cell.getDateCellValue()) + "\t\t");
				} else {
					rowDataList.add(Integer.toString((int) cell.getNumericCellValue()).trim());
				}
				break;
			case Cell.CELL_TYPE_STRING:
				rowDataList.add(cell.getStringCellValue().trim());
				break;
			case Cell.CELL_TYPE_BLANK:
				rowDataList.add("0");
				break;

			}
		}
	}

	private static void setHeaders(Iterator<Cell> cellIterator, List<String> colHeaders) {
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				colHeaders.add(cell.getNumericCellValue() + "");
				break;
			case Cell.CELL_TYPE_STRING:
				colHeaders.add(cell.getStringCellValue().trim());
				break;
			}
		}

	}
	
	public static List<CoreApps> setDataToCoreList(ArrayList<String> rowDataList){
		List<CoreApps> coreList = new ArrayList<CoreApps>();
		int ind = 0;
		while(ind<rowDataList.size()) {
			CoreApps core = new CoreApps();
			core.setReferenceNumber(Long.valueOf(rowDataList.get(ind++)));
			core.setCategory(rowDataList.get(ind++));
			core.setUserLoginId(rowDataList.get(ind++));
			core.setCreated(rowDataList.get(ind++));
			core.setAssignee(rowDataList.get(ind++));
			core.setAssignedGroup(rowDataList.get(ind++));
			core.setStatus(rowDataList.get(ind++));
			core.setCurrentAssignedGroup(rowDataList.get(ind++));
			core.setIsBreached(rowDataList.get(ind++));
			
			coreList.add(core);
		}
		return coreList;
		}
				
	}


