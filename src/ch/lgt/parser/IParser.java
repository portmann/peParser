package ch.lgt.parser;

import java.util.List;

import ch.lgt.deal.Deal;
import ch.lgt.pattern.Pattern;
import ch.lgt.processing.ExcelFile;

public interface IParser {
	
	public List<Deal> parse (Pattern pattern, ExcelFile file);

}
