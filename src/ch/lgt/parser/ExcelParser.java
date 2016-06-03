package ch.lgt.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import com.joestelmach.natty.Parser;

import ch.lgt.deal.Deal;
import ch.lgt.pattern.Figures;
import ch.lgt.pattern.Pattern;
import ch.lgt.processing.ExcelFile;

//TODO: Excel read functions in other class

public class ExcelParser implements IParser {

	// Pay attention to the fact that poi starts for row and cell at zero.
	Parser dateParser = new Parser();

	public ExcelParser() {

	}

	public int getStartField(int fieldNum, String header, ExcelFile file) {

		Iterator<Row> rowIterator = file.getSheet().rowIterator();

		while (rowIterator.hasNext()) {

			XSSFRow row = (XSSFRow) rowIterator.next();
			XSSFCell cell = row.getCell(fieldNum);
			if (cell != null)
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					if (cell.getRichStringCellValue().getString().trim().equals(header)) {
						return row.getRowNum();
					}
				}
		}
		return -1;
	}

	public int getEndField(int fieldNum, int startfield, ExcelFile file) {

		Iterator<Row> rowIterator = file.getSheet().rowIterator();
		int i = 0;

		while (rowIterator.hasNext()) {

			XSSFRow row = (XSSFRow) rowIterator.next();
			XSSFCell cell = row.getCell(fieldNum);

			if (i > startfield)
				if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK)
					return i;

			i++;
		}
		return -1;
	}

	public String getFieldString(int rowNum, int colNum, ExcelFile file) {

		XSSFRow row = file.getSheet().getRow(rowNum);
		XSSFCell cell = row.getCell(colNum);

		if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();

		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
			return Double.toString(cell.getNumericCellValue());
		}

		return "";

	}

	public double getFieldNum(int rowNum, int colNum, ExcelFile file) {

		XSSFRow row = file.getSheet().getRow(rowNum);
		XSSFCell cell = row.getCell(colNum);

		if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
			try{
			return Double.parseDouble(cell.getStringCellValue());
			}
			catch(Exception e){
				return - 1;
			}

		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
			return cell.getNumericCellValue();
		}

		return -1;
	}

	//TODO: Check if num is JJJJ
	public Date getFieldDate(int rowNum, int colNum, ExcelFile file) {

		XSSFRow row = file.getSheet().getRow(rowNum);
		XSSFCell cell = row.getCell(colNum);

		if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
			try {
				return dateParser.parse(cell.getStringCellValue()).get(0).getDates().get(0);
			} catch (Exception e) {
				return new Date();
			}
		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
			return cell.getDateCellValue();
		}
		return new Date();
	}

	@Override
	public List<Deal> parse(Pattern pattern, ExcelFile file) {

		List<Deal> deals = new ArrayList<Deal>();

		int startField = getStartField(pattern.getCompanyName().getColFieldNum(), pattern.getCompanyName().getHeader(),
				file);
		int endField = getEndField(pattern.getCompanyName().getColFieldNum(), startField, file);

		for (int i = startField + 1; i < endField; i++) {

			Deal deal = new Deal();

			deal.setCompanyName(this.getFieldString(i, pattern.getCompanyName().getColFieldNum(), file));
			deal.setCurrency(this.getFieldString(i, pattern.getCurrency().getColFieldNum(), file));

			// Entry
			if (pattern.getEntryDeal().getDataType() == Figures.DateType.TIMESTAMP)
				deal.setEntrydate(this.getFieldDate(pattern.getEntryDeal().getDate().getRowFieldNum(),
						pattern.getEntryDeal().getDate().getColFieldNum(), file));
			else
				deal.setEntrydate(this.getFieldDate(i, pattern.getEntryDeal().getDate().getColFieldNum(), file));

			deal.setEntrynetDebt(this.getFieldNum(i, pattern.getEntryDeal().getNetDebt().getColFieldNum(), file));
			deal.setEntryenterpriseValue(
					this.getFieldNum(i, pattern.getEntryDeal().getEnterpriseValue().getColFieldNum(), file));
			deal.setEntrysales(this.getFieldNum(i, pattern.getEntryDeal().getSales().getColFieldNum(), file));
			deal.setEntryebitda(this.getFieldNum(i, pattern.getEntryDeal().getEbitda().getColFieldNum(), file));
			deal.setEntryebitdaX(this.getFieldNum(i, pattern.getEntryDeal().getEbitdaX().getColFieldNum(), file));
			deal.setEntrysalesX(this.getFieldNum(i, pattern.getEntryDeal().getSalesX().getColFieldNum(), file));

			// Current
			if (pattern.getCurrentDeal().getDataType() == Figures.DateType.TIMESTAMP)
				deal.setCurrentdate(this.getFieldDate(pattern.getCurrentDeal().getDate().getRowFieldNum(),
						pattern.getCurrentDeal().getDate().getColFieldNum(), file));
			else
				deal.setCurrentdate(this.getFieldDate(i, pattern.getCurrentDeal().getDate().getColFieldNum(), file));

			deal.setCurrentnetDebt(this.getFieldNum(i, pattern.getCurrentDeal().getNetDebt().getColFieldNum(), file));
			deal.setCurrententerpriseValue(
					this.getFieldNum(i, pattern.getCurrentDeal().getEnterpriseValue().getColFieldNum(), file));
			deal.setCurrentsales(this.getFieldNum(i, pattern.getCurrentDeal().getSales().getColFieldNum(), file));
			deal.setCurrentebitda(this.getFieldNum(i, pattern.getCurrentDeal().getEbitda().getColFieldNum(), file));

			deal.setCurrentirr(this.getFieldNum(i, pattern.getCurrentDeal().getIrr().getColFieldNum(), file));
			deal.setCurrentebitdaX(this.getFieldNum(i, pattern.getCurrentDeal().getEbitdaX().getColFieldNum(), file));
			deal.setCurrentsalesX(this.getFieldNum(i, pattern.getCurrentDeal().getSalesX().getColFieldNum(), file));

			deals.add(deal);

		}

		return deals;
	}

}
