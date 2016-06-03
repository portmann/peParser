package ch.lgt.test;

import com.google.gson.Gson;

import ch.lgt.helper.FileHandler;
import ch.lgt.pattern.Figures;
import ch.lgt.pattern.Field;
import ch.lgt.pattern.Pattern;

public class SaveJson {
	
	public static void main(String args[])throws Exception
	   {
		
		Gson gson = new Gson();
		
		Pattern pattern = new Pattern();
		Figures figure = new Figures();
		
		FileHandler filehandler = new FileHandler();
		
		pattern.setAlignment(true);
		pattern.setWorksheetName("dealTable");
		pattern.setFileUrl("FileUrl");
		
		Field stringField = new Field();
		stringField.setColFieldNum(2);
		stringField.setHeader("ThisIsAField!");
		stringField.setDataType(Field.DataType.String);
		
		Field numField = new Field();
		numField.setColFieldNum(5);
		numField.setHeader("ThisIsAField!");
		numField.setDataType(Field.DataType.Num);
		
		Field dateField = new Field();
		dateField.setRowFieldNum(9);
		dateField.setColFieldNum(8);
		dateField.setHeader("ThisIsAField!");
		dateField.setDataType(Field.DataType.Date);
		
		pattern.setCompanyName(stringField);

		pattern.setCurrency(stringField);
		
		//set up deal
		
		figure.setDataType(Figures.DateType.TIMESTAMP);
		
		figure.setDate(dateField);
		figure.setEbitda(numField);
		figure.setEbitdaX(numField);
		figure.setEnterpriseValue(numField);
		figure.setIrr(numField);
		figure.setNetDebt(numField);
		figure.setSales(numField);
		figure.setSalesX(numField);
		
		pattern.setCurrentDeal(figure);
		pattern.setEntryDeal(figure);
		
		String jsonString = gson.toJson(pattern);
		System.out.print(jsonString);
		
		filehandler.saveStringAsFile("patterns/dummy.json", jsonString);
	
	   }
}
