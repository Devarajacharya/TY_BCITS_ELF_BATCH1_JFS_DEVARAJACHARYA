package com.bcits.MyjavaApp.common;

import com.bcits.calculater.basic.BasicCalculator;

public class MyJavaApplicationstartedProgram {
	
	public static void main(String[] args) {
		BasicCalculator b1 = new BasicCalculator();
		int sum = b1.add(12, 18);
		System.out.println("sum is : "+sum);
	}

}
