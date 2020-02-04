package com.bcits.usecasemodule.tariff;

public class BillCalculator {
	public static double residentialConsumer(long totalUnit) {
		double bill = 0;
		if ((totalUnit > 0) && (totalUnit <= 100)) {
			bill = (totalUnit * 4);
		} else if (totalUnit <= 200) {
			bill = (100 * 4) + ((totalUnit - 100) * 5);
		} else if (totalUnit > 200) {
			bill = (100 * 4) + (100 * 5) + ((totalUnit - 200) * 8);
		} 
		return bill;
	}

	public static double commercialConsumer(long totalUnit) {

		double bill = 0;
		if (totalUnit > 0 && totalUnit <= 100) {
			bill = (totalUnit * 10);
		} else if (totalUnit > 100 && totalUnit <= 200) {
			bill = (100 * 10) + ((totalUnit - 100) * 15);
		} else if (totalUnit > 200) {
			bill = (100 * 10) + (100 * 15) + ((totalUnit - 200) * 18);
		}
		return bill;
	}
	
	public static double industriesConsumer(long totalUnit) {

		double bill = 0;
		if (totalUnit > 0 && totalUnit <= 100) {
			bill = (totalUnit * 15);
		} else if (totalUnit > 100 && totalUnit <= 200) {
			bill = (100 * 15) + ((totalUnit - 100) * 20);
		} else if (totalUnit > 200) {
			bill = (100 * 15) + (100 * 20) + ((totalUnit - 200) * 25);
		} 
		return bill;
	}

}
