package com.bcits.springcoreanotation.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcoreanotation.beans.Car;

public class CarTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Car myCar = context.getBean("car", Car.class);
		System.out.println("Car Company : "+myCar.getCompany());
		System.out.println("Engine CC   : "+myCar.getEngin().getCc());
		System.out.println("Type        : "+myCar.getEngin().getType());
	}

}
