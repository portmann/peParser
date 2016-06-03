package ch.lgt.processing;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFile {

	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet;

	public ExcelFile(String path, String worksheet) {

		try {

			this.workbook = openExcel(path);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.sheet = this.workbook.getSheet(worksheet);
	}

	// Just Xlsx fiels
	public XSSFWorkbook openExcel(String path) throws Exception {
		FileInputStream fIP = new FileInputStream(path);
		return new XSSFWorkbook(fIP);
	}

	public XSSFSheet openSheet(String name) {
		return this.workbook.getSheet(name);
	}
	
	public XSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(XSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

}
