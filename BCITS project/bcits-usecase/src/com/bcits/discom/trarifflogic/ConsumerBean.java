package com.bcits.discom.trarifflogic;

public class ConsumerBean {
	private String rrNumber;
	private String name;
	private String typeOfConsumer;
	private long prev;
	private long pres;
	private long totalUnit;
	private double billAmt;

	public ConsumerBean(String rrNumber, String name, String typeOfConsumer, long prev, long pres,
			long totalUnit, double billAmt) {
		super();
		this.rrNumber = rrNumber;
		this.name = name;
		this.typeOfConsumer = typeOfConsumer;
		this.billAmt = billAmt;
		this.prev = prev;
		this.pres = pres;
		this.totalUnit = totalUnit;
	}

	/**
	 * @return the rrNumber
	 */
	public String getRrNumber() {
		return rrNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the typeOfConsumer
	 */
	public String getTypeOfConsumer() {
		return typeOfConsumer;
	}

	/**
	 * @return the billAmt
	 */
	public double getBillAmt() {
		return billAmt;
	}

	/**
	 * @param rrNumber the rrNumber to set
	 */
	public void setRrNumber(String rrNumber) {
		this.rrNumber = rrNumber;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param typeOfConsumer the typeOfConsumer to set
	 */
	public void setTypeOfConsumer(String typeOfConsumer) {
		this.typeOfConsumer = typeOfConsumer;
	}

	/**
	 * @param billAmt the billAmt to set
	 */
	public void setBillAmt(double billAmt) {
		this.billAmt = billAmt;
	}

	/**
	 * @return the prev
	 */
	public long getPrev() {
		return prev;
	}

	/**
	 * @return the pres
	 */
	public long getPres() {
		return pres;
	}

	/**
	 * @return the totalUnit
	 */
	public long getTotalUnit() {
		return totalUnit;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(long prev) {
		this.prev = prev;
	}

	/**
	 * @param pres the pres to set
	 */
	public void setPres(long pres) {
		this.pres = pres;
	}

	/**
	 * @param totalUnit the totalUnit to set
	 */
	public void setTotalUnit(long totalUnit) {
		this.totalUnit = totalUnit;
	}

	@Override
	public String toString() {
		return "\n"+"------------------------------"+ "\n"
				   +"RR Number        : " + rrNumber + "\n" 
				   + "Name             : " + name + "\n"
				   + "Type Of Consumer : " + typeOfConsumer + "\n" 
				   + "Previous reading : " + prev +"\n" 
				   + "presence reading : " +pres +"\n" 
				   + "Total Units      : " +totalUnit+"\n"
				   + "Bill Amount      : " + billAmt+"\n"
				   +"-------------------------------";
	}
}
