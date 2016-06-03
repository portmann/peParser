package ch.lgt.pattern;

public class Figures {
	
	public enum DateType {
		TIMESERIES, TIMESTAMP
	}
	
	DateType dataType;
	Field date;
	Field netDebt;
	Field enterpriseValue;
	Field sales;
	Field ebitda;
	Field irr;
	Field ebitdaX;
	Field salesX;

	
	public DateType getDataType() {
		return dataType;
	}
	public void setDataType(DateType dataType) {
		this.dataType = dataType;
	}
	public Field getDate() {
		return date;
	}
	public void setDate(Field date) {
		this.date = date;
	}
	public Field getNetDebt() {
		return netDebt;
	}
	public void setNetDebt(Field netDebt) {
		this.netDebt = netDebt;
	}
	public Field getEnterpriseValue() {
		return enterpriseValue;
	}
	public void setEnterpriseValue(Field enterpriseValue) {
		this.enterpriseValue = enterpriseValue;
	}
	public Field getSales() {
		return sales;
	}
	public void setSales(Field sales) {
		this.sales = sales;
	}
	public Field getEbitda() {
		return ebitda;
	}
	public void setEbitda(Field ebitda) {
		this.ebitda = ebitda;
	}
	public Field getIrr() {
		return irr;
	}
	public void setIrr(Field irr) {
		this.irr = irr;
	}
	public Field getEbitdaX() {
		return ebitdaX;
	}
	public void setEbitdaX(Field ebitdaX) {
		this.ebitdaX = ebitdaX;
	}
	public Field getSalesX() {
		return salesX;
	}
	public void setSalesX(Field salesX) {
		this.salesX = salesX;
	}

	
	

}

