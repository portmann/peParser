package ch.lgt.test;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
	public static void main(String args[])throws Exception
	   { 
	      File file = new File("testFiles/Test1.xlsx");
	      FileInputStream fIP = new FileInputStream(file);
	      //Get the workbook instance for XLSX file 
	      @SuppressWarnings("resource")
	      XSSFWorkbook workbook = new XSSFWorkbook(fIP);
	      XSSFSheet sheet = workbook.getSheet("Investment data sheet");
	      
	      if(file.isFile() && file.exists())
	      {
	         System.out.println(
	         "File open successfully.");
	         
	         XSSFRow row     = sheet.getRow(8);        
	         XSSFCell cell   = row.getCell(8); 
	         
	         String output;
	         
	         if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
	        	 output = "The Cell was a String with value " + cell.getStringCellValue();
	        	} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
	        	 output = "The cell was a number " + cell.getNumericCellValue();
	        	 
	        	    if (HSSFDateUtil.isCellDateFormatted(cell)) {
	        	        System.out.println (cell.getDateCellValue());
	        	    }
	        	 
	        	} else {
	        	 output = "The cell was nothing we're interested in";
	        	}
	         
	         System.out.println(output);
	         
	      }
	      else
	      {
	         System.out.println(
	         "Error to open file.");
	      }
	   }
}
