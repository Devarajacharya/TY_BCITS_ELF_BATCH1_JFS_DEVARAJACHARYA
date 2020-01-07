/*WAP to store five product bean object into ArrayList and display the content of which has a cost price less than 2000*/
package com.bcits.practice.fourth;

import java.util.ArrayList;

public class ProductInfo {
	public static void main(String[] args) {
		Product p1 = new Product();
		p1.setName("Mobile");
		p1.setPrice(29000);
		p1.setBrand("OnePluse");
		
		Product p2 = new Product();
		p2.setName("bag");
		p2.setPrice(1500);
		p2.setBrand("Wildcraft");
		
		Product p3 = new Product();
		p3.setName("Shoe");
		p3.setPrice(2900);
		p3.setBrand("Nike");
		
		Product p4 = new Product();
		p4.setName("Watch");
		p4.setPrice(8090);
		p4.setBrand("Fossile");
		
		Product p5 = new Product();
		p5.setName("headphone");
		p5.setPrice(1599);
		p5.setBrand("Boat");
		
		
		ArrayList<Product> a1= new ArrayList<>();
			a1.add(p1);
			a1.add(p2);
			a1.add(p3);
			a1.add(p4);
			a1.add(p5);
			
		for(Object obj : a1) {
			if(((Product) obj).getPrice() >2000) {
			System.out.println(obj);
		}
		}
		
	}
}
