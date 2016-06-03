package ch.lgt.pattern;

public class Field {
	
	public enum DataType {
		String, Num, Date
	}
	
	int colFieldNum; // standard its the column 
	int rowFieldNum;
	String header;
	DataType dataType;

	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public DataType getDataType() {
		return dataType;
	}
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	public int getColFieldNum() {
		return colFieldNum;
	}
	public void setColFieldNum(int colFieldNum) {
		this.colFieldNum = colFieldNum;
	}
	public int getRowFieldNum() {
		return rowFieldNum;
	}
	public void setRowFieldNum(int rowFieldNum) {
		this.rowFieldNum = rowFieldNum;
	}
	
	

}
