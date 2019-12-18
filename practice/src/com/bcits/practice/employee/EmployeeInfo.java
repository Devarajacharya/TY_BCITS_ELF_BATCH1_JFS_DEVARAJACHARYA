package com.bcits.practice.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeInfo {
	
	private static Scanner sd;
	private static int num;

	public static void main(String[] args) {
	ArrayList<Employee> a1=new ArrayList<>();
	a1.add(new Employee(10,"jaddu",26000));
	a1.add(new Employee(30,"dinga",19000));
	a1.add(new Employee(50,"pandu",16000));
	a1.add(new Employee(40,"ninja",22000));
	a1.add(new Employee(20,"geddu",42000));

	sd = new Scanner(System.in);
	System.out.println("1)Name  2)Id   3)Sal");
	System.out.println("Enter the your choice : ");
	num = sd.nextInt();
	if (num == 1) {
		Collections.sort(a1,new SortByName());
	} else if(num == 2) {
		Collections.sort(a1,new SortById());
	} else {
		Collections.sort(a1,new SortBySal());
	}
	for(Employee e1 : a1) {
		System.out.println(e1);
	}
	
	}
}

