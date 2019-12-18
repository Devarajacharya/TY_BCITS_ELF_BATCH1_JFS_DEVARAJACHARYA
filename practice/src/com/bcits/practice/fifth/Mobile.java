package com.bcits.practice.fifth;

public class Mobile implements Comparable  {
	
	private String name;
	private int price;
	public Mobile(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Mobile name=" + name + "\n"+"price=" + price + "\n";
	}
	@Override
	public int compareTo(Object obj) {
		Mobile p1=(Mobile)obj;
		return this.getPrice()-p1.getPrice();
	}
	
	
	
}

