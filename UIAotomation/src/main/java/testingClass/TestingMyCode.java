package testingClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestingMyCode {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileInputStream fis;
	public static FileOutputStream fisout = null;;
	public static String path;
	public static XSSFCell cells;
	public static XSSFRow rows;
	//public static String testData[][]=null;

	public static void main(String[] args) {

		String testData[][]=null;
		String path = "C:\\Users\\kevser\\Desktop\\TestData.xlsx";

		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sheet=workbook.getSheet("sheet1");
		int totalRows=sheet.getLastRowNum()+1;
		int totalCells=sheet.getRow(0).getLastCellNum();
		System.out.println("rows count:"+totalRows+" ,and cells count: "+totalCells);
		
		for(int i=1;i<totalRows;i++){
			XSSFRow rows=sheet.getRow(i);
			
			for(int j=0;j<totalCells;j++){
				
				XSSFCell cells=rows.getCell(j);
				
				if (cells.getCellType() == cells.CELL_TYPE_STRING)
					testData[i - 1][j] = cells.getStringCellValue();

				// if cell value is number, this else if condition will work
				else if (cells.getCellType() == cells.CELL_TYPE_NUMERIC) {
					testData[i - 1][j] = String.valueOf(cells.CELL_TYPE_NUMERIC);
				}
				// if cell value id boolean, this else condition will work
				else
					testData[i - 1][j] = String.valueOf(cells.CELL_TYPE_BOOLEAN);
				
			}
			
		}
	



	}
}
