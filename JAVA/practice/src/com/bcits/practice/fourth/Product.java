package com.bcits.practice.fourth;

import java.io.Serializable;

public class Product implements Serializable {
	
	private String name;
	private double price;
	private String brand;
	public Product() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Product name =  " + name +"\n"+ "price =   " + price +"\n"+ "brand =   " + brand+"\n" ;
	}

}
