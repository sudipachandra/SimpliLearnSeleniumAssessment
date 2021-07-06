package com.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static Object[][] ReadExcelDataToObjArray(String filepath,String filename,String sheetname) throws IOException{
		 File file = new File(filepath + "/" + filename); //ppinting to phyical location of file
		 FileInputStream inputStream = new FileInputStream(file);//open the file in read mode
		 Workbook workbook= new XSSFWorkbook(inputStream); 	 
		 Sheet sheet  = workbook.getSheet(sheetname);
		 int rowCount = sheet.getLastRowNum(); //Give the Row Count - does not include column header
		 System.out.println("rowCount = " + rowCount) ;  //only returns data record count
		 //declare a 2 dimensional object array
		 Object[][] data = new Object[rowCount][1];
		 //declare a hashtable and initialize to null
		 Hashtable<String,String> rec = null;
		 //we need to create a hashtable for each recordset -so it will come under for row loop
		 //Keys row - or Colum header Row - which applies to all data rows
		 //first row - age = 45, sex = f, heightmeter = 160
		 //second row - age = 56, sex = m, heightmeter = 200
		 Row keysRow = sheet.getRow(0); //Keys Row
		 for(int r = 1; r<rowCount+1;r++){
			 Row dataRow = sheet.getRow(r);
			 rec = new Hashtable<String,String>();
			 for(int c = 0; c<dataRow.getLastCellNum();c++){
				 System.out.println(keysRow.getCell(c).getStringCellValue());
				 String key = keysRow.getCell(c).getStringCellValue();
				 String val = dataRow.getCell(c).getStringCellValue();
				 rec.put(key, val);
			 }
			 data[r-1][0] = rec;
		 }
		 return data;
		}
	public static void ReadExcelData(String filepath,String filename,String sheetname) throws IOException{
	 //Create an instance of FileInputStream - used for input Operation
	 File file = new File(filepath + "/" + filename); //ppinting to phyical location of file
	 FileInputStream inputStream = new FileInputStream(file);//open the file in read mode
	 //Excel - there are 2 formats - xls and another is the xlsx
	 //for xls - we need to use HSSFWorkbook and for xlsx we use XSSFWorkbook
	 //with the help of extension - you can know which one to use 
	// if(filename.endsWith(".xlsx")){
	 Workbook workbook= new XSSFWorkbook(inputStream); 	 
	 Sheet sheet  = workbook.getSheet(sheetname);
	 int rowCount = sheet.getLastRowNum(); //Give the Row Count - does not include column header
	 System.out.println("rowCount = " + rowCount) ;  //only returns data record count
	 for(int r = 0; r<rowCount+1;r++){
		 Row row = sheet.getRow(r);
		 for(int c = 0; c<row.getLastCellNum();c++){
			 Cell col = row.getCell(c);
			 System.out.print(col.getStringCellValue() + "\t");
		 }
		 System.out.println("");
	 }
	}
	
	//This is temporary testing
	public static void main(String[] args) throws IOException{
		String ProjectPath = System.getProperty("user.dir");//this will return project current directory path 
		System.out.println("ProjectPath = " + ProjectPath);
		String filepath  = ProjectPath +"/src/com/caloriecalc/testdata";
		String filename = "CalorieData.xlsx";
		String sheetname = "CalorieTestSet";
		ExcelReader.ReadExcelData(filepath, filename, sheetname);
	}

}