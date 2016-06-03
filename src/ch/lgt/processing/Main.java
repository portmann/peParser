package ch.lgt.processing;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import ch.lgt.deal.Deal;
import ch.lgt.helper.FileHandler;
import ch.lgt.parser.ExcelParser;
import ch.lgt.parser.IParser;

public class Main {

	public static void main(String args[]) throws Exception {

		IParser parser = new ExcelParser();
		List<Deal> deals = new ArrayList<Deal>();

		String patternUrl = "patterns/pattern3.json";

		Corpus corpus = new Corpus();
		corpus.addPattern(patternUrl);
		
		for (int i = 0; i < corpus.count(); i++) {

			deals.addAll(parser.parse(corpus.getPattern(i), corpus.getFile(i)));

		}
		
		Gson gson = new Gson();
		FileHandler fileHandler = new FileHandler();
		
		String jsonString = gson.toJson(deals);
		System.out.print(jsonString);
		
		fileHandler.saveStringAsFile("results/output1.json", jsonString);

	}

}
