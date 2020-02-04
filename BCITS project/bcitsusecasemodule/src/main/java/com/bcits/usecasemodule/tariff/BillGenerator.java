package com.bcits.usecasemodule.tariff;

public class BillGenerator {

	public static double getBill(String typeOfCons ,long prev ,long pres ) {
		long totalUnit = pres-prev;
		if(typeOfCons.equalsIgnoreCase("Residential consumers")) {
			return BillCalculator.residentialConsumer(totalUnit);
		}else if(typeOfCons.equalsIgnoreCase("Commercial consumers")) {
			return BillCalculator.commercialConsumer(totalUnit);
		} else if (typeOfCons.equalsIgnoreCase("Industries")) {
			return BillCalculator.industriesConsumer(totalUnit);
		}else {
		return pres;
		}
	}
}
