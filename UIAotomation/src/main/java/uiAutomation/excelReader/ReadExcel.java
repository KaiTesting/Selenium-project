package uiAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public FileInputStream fis;
	public FileOutputStream fisout = null;;
	public String path;
	public XSSFCell cells;
	public XSSFRow rows;

	public ReadExcel(String path) {
		this.path = path;
		try {
			fis = new FileInputStream("path");
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	

	public String[][] readAllDataFromSheet(String sheetName,String excelName) {

		String dataSets[][] = null;

		// get sheet from excel workbook
		XSSFSheet sheet = workbook.getSheet(sheetName);

		// get total number of rows
		int totalRows = sheet.getLastRowNum() + 1;

		// get total number of cells
		int totalCells = sheet.getRow(0).getLastCellNum();

		// create array of row and column
		dataSets = new String[totalRows - 1][totalCells];

		for (int i = 1; i < totalRows; i++) {
			// This loop will run on the rows
			XSSFRow rows = sheet.getRow(i);

			for (int j = 0; j < totalCells; j++) {
				// get cell method will get cell value
				XSSFCell cell = rows.getCell(j);

				// if cell value is String, this if condition will work
				if (cell.getCellType() == cell.CELL_TYPE_STRING)
					dataSets[i - 1][j] = cell.getStringCellValue();

				// if cell value is number, this else if condition will work
				else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
					dataSets[i - 1][j] = String.valueOf(cell.CELL_TYPE_NUMERIC);
				}
				// if cell value id boolean, this else condition will work
				else
					dataSets[i - 1][j] = String.valueOf(cell.CELL_TYPE_BOOLEAN);

			}

		}
		return dataSets;

	}

}
