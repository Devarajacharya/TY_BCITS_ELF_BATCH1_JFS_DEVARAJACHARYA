package com.bcits.discom.trarifflogic;

import java.util.Scanner;

public class Employee {
	
	public static boolean employeeLogin() {
		Scanner scan = new Scanner(System.in);
		String empId = "123ABC";
		String designation = "manager";
		System.out.print("Enter the Employee ID : ");
		String empIdValue = scan.nextLine();
		System.out.print("Enter Designation     : ");
		String designationValue = scan.nextLine();
		if (empId.equals(empIdValue) && designation.equals(designationValue)) {
			return true;
		} else {
			return false;
		}
	
	}
	
	

}
