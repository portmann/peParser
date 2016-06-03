package ch.lgt.processing;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import ch.lgt.helper.FileHandler;
import ch.lgt.pattern.Pattern;

public class Corpus {

	@SuppressWarnings("unused")
	private class PatternFile {
		private Pattern pattern;
		private ExcelFile file;

		public PatternFile(Pattern pattern, ExcelFile file) {
			this.pattern = pattern;
			this.file = file;
		}
		
		public Pattern getPattern() {
			return pattern;
		}

		public void setPattern(Pattern pattern) {
			this.pattern = pattern;
		}

		public ExcelFile getFile() {
			return file;
		}

		public void setFile(ExcelFile file) {
			this.file = file;
		}
		
	}

	private List<PatternFile> patternFiles = new ArrayList<PatternFile>();

	public Corpus() {

	}

	public void addPattern(String url) {

		Gson gson = new Gson();
		FileHandler filehandler = new FileHandler();

		String json = filehandler.loadFileToString(url);
		Pattern pattern = gson.fromJson(json, Pattern.class);

		PatternFile patternFile = new PatternFile(pattern,
				new ExcelFile(pattern.getFileUrl(), pattern.getWorksheetName()));

		this.patternFiles.add(patternFile);

	}

	public int count() {
		return patternFiles.size();
	}
	
	public Pattern getPattern(int i){
		
		return this.patternFiles.get(i).getPattern();
		
	}
	
	public ExcelFile getFile(int i){
		
		return this.patternFiles.get(i).getFile();
		
	}

}
