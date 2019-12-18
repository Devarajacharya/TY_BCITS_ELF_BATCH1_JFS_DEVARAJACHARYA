package com.bcits.practice.employee;

public class Employee {
	
	int id;
	String name;
	double sal;
	
	public Employee(int id, String name, double sal) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee id=" + id + "\n"+"name=" + name +"\n"+ "sal=" + sal + "\n";
	}

}

