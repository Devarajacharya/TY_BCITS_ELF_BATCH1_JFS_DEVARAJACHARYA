package com.bcits.springcore;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;

public class EmployeeTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeBean employeeBean1 = (EmployeeBean) context.getBean("employee");
		EmployeeBean employeeBean2 = (EmployeeBean) context.getBean("employee");
		
		System.out.print("Enter Employee Name  : ");
		employeeBean1.setName(sc.nextLine());
		System.out.print("Enter Employee Age :");
		employeeBean1.setAge(sc.nextInt());
		sc.nextLine();
		
		System.out.print("Enter Employee Name  : ");
		employeeBean2.setName(sc.nextLine());
		System.out.print("Enter Employee Age :");
		employeeBean2.setAge(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Name : "+employeeBean1.getName());
		System.out.println("Age  : "+employeeBean1.getAge());
		System.err.println("Name : "+employeeBean2.getName());
		System.err.println("Age  : "+employeeBean2.getAge());
	}

}
