package testNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ParseExcelData {
	
	@Test
	public void readExcelData() throws IOException {
		
		FileInputStream fis = new FileInputStream("path");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("test");
		
		for(int row=0; row<sheet.getLastRowNum();row++) {
			Row rowValues = sheet.getRow(row);
			for(int cell=0; cell<rowValues.getLastCellNum(); cell++) {
				String value = rowValues.getCell(cell).getStringCellValue();
			}
		}
	}
	
	
	@Test
	public void writeExcelData() throws IOException {
		
		FileInputStream fis = new FileInputStream("path");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("test");
		
		Row row = sheet.getRow(0);  // Read first row
		Cell cell = row.getCell(0);  // Read first cell from first row
		
		// Create new row and 
		 Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);

	        // Write data into new cells
	        newRow.createCell(0).setCellValue("user_new");
	        newRow.createCell(1).setCellValue("password_new");
	        newRow.createCell(2).setCellValue("PASS");

	        fis.close(); // close input before writing

	        // Write back to file
	        FileOutputStream fos = new FileOutputStream("TestData.xlsx");
	        workbook.write(fos);
	        workbook.close();
	        fos.close();
	}


}
