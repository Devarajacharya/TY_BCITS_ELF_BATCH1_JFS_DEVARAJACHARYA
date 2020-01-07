package com.bcits.practice.fourth;

import java.util.ArrayList;

public class EmployeeInfo {
	
	public static void main(String[] args) {
	ArrayList<Employee> a1=new ArrayList<>();
	a1.add(new Employee(10,"Jaddu",26000));
	a1.add(new Employee(20,"dinga",19000));
	a1.add(new Employee(30,"pandu",16000));
	a1.add(new Employee(40,"ninja",22000));
	a1.add(new Employee(50,"geddu",42000));

	for(Employee e1 : a1) {
		System.out.println(e1);
	}
	
	}
}
