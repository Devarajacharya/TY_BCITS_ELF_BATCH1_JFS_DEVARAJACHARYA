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

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public double getSal() {
		return sal;
	}


	@Override
	public String toString() {
		return "Employee id=" + id + "\n"+"name=" + name +"\n"+ "sal=" + sal + "\n";
	}

}

