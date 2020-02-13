package com.jci.ImapFramework.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jci.ImapFramework.TestBase.TestBase;
import com.jci.ImapFramework.helper.logger.LoggerHelper;
import com.jci.ImapFramework.helper.recourse.Recourcehelper;

public class Excelhelper extends TestBase {

	private Logger log = LoggerHelper.getLogger(Excelhelper.class);

	public Object[][] getExcelData(String excelLocation, String sheetName) {
		try {

			Object dataset[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create workbook instance like object of workbook

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get sheet name from workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// count no of active rows in excel sheet
			int totalrow = sheet.getLastRowNum();
			System.out.println(totalrow);

			// count active columns in the row
			int totalcol = sheet.getRow(0).getLastCellNum();
			dataset = new Object[totalrow+1][totalcol];
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext())
				i++;
			// for every row we need to iterate over columns
			{
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {
					j++;
					Cell cell = cellIterator.next();

					
					switch (cell.getCellType()) {
					case STRING:
						dataset[i-1][j-1] = cell.getStringCellValue();
						break;

					case NUMERIC:
						dataset[i-1][j-1] = cell.getNumericCellValue();
						break;

					case BOOLEAN:
						dataset[i-1][j-1] = cell.getBooleanCellValue();
						break;

					case FORMULA:
						dataset[i-1][j-1] = cell.getCellFormula();
						break;

					default:
						System.out.println("No matching enum data type found");
						break;
					}
				}
			}
			return dataset;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void UpdateResultToExcel(String excellocation,String Sheetname,String testcasename,String teststatus)
	{
		try
		{
			FileInputStream file = new FileInputStream(new File(excellocation));
			// Create workbook instance like object of workbook
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get sheet name from workbook
			XSSFSheet sheet = workbook.getSheet(Sheetname);
			// count no of active rows in excel sheet
			int totalrow = sheet.getLastRowNum()+1;
			for(int i=1;i<totalrow;i++)
			{
				XSSFRow R = sheet.getRow(i);
				String CE = R.getCell(0).getStringCellValue();
				if(CE.contains(testcasename))
				{
					R.createCell(1).setCellValue(teststatus);
					file.close();
					log.info("Result updated...Sheet TestScriptExecuted Sucessfully");
					FileOutputStream out = new FileOutputStream(new File(excellocation));
					workbook.write(out);
					out.close();
					break;
				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Excelhelper excelhelper=new Excelhelper(); 
		String excelLocation =Recourcehelper.getRecourcePath("/src/main/recources/configfile/TestData.xlsx");
		//Object[][] data = excelhelper.getExcelData(excelLocation, "Login");
		excelhelper.UpdateResultToExcel(excelLocation, "TestScript", "Login", "PASS");
		excelhelper.UpdateResultToExcel(excelLocation, "TestScript", "Registration", "FAIL");
		excelhelper.UpdateResultToExcel(excelLocation, "TestScript", "Add to Cart", "PASS");
	}
	
	
}
