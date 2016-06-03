package ch.lgt.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.lgt.processing.ExcelFile;

public class ExcelParserTest {

	@Test
	public void testGetStartField() {

		ExcelFile file = new ExcelFile("testFiles/Test1.xlsx", "Investment data sheet");
		ExcelParser parser = new ExcelParser();
		int cell = parser.getStartField(1, "Companies", file);
		assertEquals(5, cell);

	}

	@Test
	public void testGetEndField() {
		
		ExcelFile file = new ExcelFile("testFiles/Test1.xlsx", "Investment data sheet");
		ExcelParser parser = new ExcelParser();
		int cell = parser.getEndField(1, 5, file);
		assertEquals(44, cell);
		
	}

}
