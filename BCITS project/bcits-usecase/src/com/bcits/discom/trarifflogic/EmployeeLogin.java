package com.bcits.discom.trarifflogic;

import java.util.Scanner;

public class EmployeeLogin {

	public static void login() {
		String password = "qwerty";
		Scanner sd = new Scanner(System.in);
		System.out.print("Enter RR / Meter Number : ");
		String rrNum = sd.nextLine();
		System.out.print("Enter the Password : ");
		String psw = sd.nextLine();
		if ((Validation.rrValidation(rrNum)) && (MainClass.map.get(rrNum)).equals(rrNum) && (psw.equals(password))) {
			System.err.println("\n" + "Invalid RR number or password..!!");
		}else {
			System.out.println(MainClass.map.get(rrNum));
		}
		
		
	}
}
