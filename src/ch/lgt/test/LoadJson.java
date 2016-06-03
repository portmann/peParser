package ch.lgt.test;

import com.google.gson.Gson;

import ch.lgt.helper.FileHandler;
import ch.lgt.pattern.Pattern;

public class LoadJson {

	public static void main(String args[]) throws Exception {

		Gson gson = new Gson();
		FileHandler filehandler = new FileHandler();
		
		String json = filehandler.loadFileToString("patterns/dummy.json");
		System.out.println(json);
		
		Pattern pattern = gson.fromJson(json, Pattern.class);
		System.out.println(pattern.getCompanyName().getHeader());

	}

}
