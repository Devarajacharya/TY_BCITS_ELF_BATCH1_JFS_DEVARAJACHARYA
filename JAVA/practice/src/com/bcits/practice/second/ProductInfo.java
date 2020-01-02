package com.bcits.practice.second;

public class ProductInfo {
	
	public static void main(String[] args) {
		Product p1=new Product();
		p1.setName("shoe");
		p1.setBrand("Nike");
		p1.setPrice(2999);	
		
		Product p2=new Product();
		p2.setName("Bag");
		p2.setBrand("WildCraft");
		p2.setPrice(1200);	
		
		Product p3=new Product();
		p3.setName("Watch");
		p3.setBrand("Fossil");
		p3.setPrice(9500);	
		
		Product p4=new Product();
		p4.setName("Mobile");
		p4.setBrand("OnePlus");
		p4.setPrice(32999);	
		
		Object [] arr= {p1,p2,p3,p4};
		
		for (Object data : arr) {
			System.out.println(data);
		}
	}

}
