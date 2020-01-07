package com.bcits.practice.employee;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchEmp {
	
	static int num;
	static String str ;
	private static Scanner sd;
	public static void main(String[] args) {
		ArrayList<Employee> a2=new ArrayList<>();
		a2.add(new Employee(10,"jaddu",26000));
		a2.add(new Employee(30,"dinga",19000));
		a2.add(new Employee(50,"pandu",16000)); 
		
		
		a2.add(new Employee(40,"ninja",22000));
		a2.add(new Employee(20,"geddu",42000));

		sd = new Scanner(System.in);
		System.out.println("Get the employee details by   1.Id    2.Name  ");
		System.out.println("Enter your choice : ");
		int choice =Integer.parseInt(sd.nextLine());
		if (choice == 1) {
			System.out.println("Enter the Id : ");
			num = sd.nextInt();
		} else if (choice == 2) {
			System.out.println("Enter the name : ");
			str = sd.nextLine();
		} else {
			System.out.println("Invalid Entry..!!!");
		}
		for ( Object obj : a2) {
			if((((Employee) obj).getId() == num ) || (((Employee) obj).getName()).equals(str) ) {
				System.out.println(obj);
			}
		}
	}
}
