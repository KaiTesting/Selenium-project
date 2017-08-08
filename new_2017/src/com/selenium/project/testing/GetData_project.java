/**
 * 
 */
package com.selenium.project.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author kevser
 *
 */
public class GetData_project {

	static XSSFWorkbook wb;

	static XSSFSheet sheet;

	public static void excelConfig(String path) {

		File fileLocation = new File(path);

		try {
			FileInputStream fis = new FileInputStream(fileLocation);

			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println("[" + e.getMessage() + "]");
			e.printStackTrace();
		}

	}
	
	public static String getData(int sheetNumber,int row,int column){

		sheet=wb.getSheetAt(sheetNumber);
		
		String sheetData=sheet.getRow(row).getCell(column).getStringCellValue();
		
		return sheetData;
	}

	public static int getRowCount(int sheetIndex){
		
		int row=wb.getSheetAt(sheetIndex).getLastRowNum();
		
		row = row+1;
		
		return row;
	}
}
