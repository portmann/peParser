package ch.lgt.pattern;

public class Pattern {
	
	//Header
	boolean alignment;
	String worksheetName;
	String fileUrl;


	//Looping Data
	//Deal
	Field companyName;
	Field currency;
	
	//At Entry
	Figures entryFigures;
	
	//At current - exit
	Figures currentFigures;
	
	public boolean isAlignment() {
		return alignment;
	}

	public void setAlignment(boolean alignment) {
		this.alignment = alignment;
	}

	public String getWorksheetName() {
		return worksheetName;
	}

	public void setWorksheetName(String worksheetName) {
		this.worksheetName = worksheetName;
	}
	
	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileName) {
		this.fileUrl = fileName;
	}

	public Field getCompanyName() {
		return companyName;
	}

	public void setCompanyName(Field companyName) {
		this.companyName = companyName;
	}

	public Field getCurrency() {
		return currency;
	}

	public void setCurrency(Field currency) {
		this.currency = currency;
	}

	public Figures getEntryDeal() {
		return entryFigures;
	}

	public void setEntryDeal(Figures entryDeal) {
		this.entryFigures = entryDeal;
	}

	public Figures getCurrentDeal() {
		return currentFigures;
	}

	public void setCurrentDeal(Figures currentDeal) {
		this.currentFigures = currentDeal;
	}
	
	
}
