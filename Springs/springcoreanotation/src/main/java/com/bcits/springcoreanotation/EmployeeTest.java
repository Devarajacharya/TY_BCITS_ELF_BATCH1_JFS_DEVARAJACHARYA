package com.bcits.springcoreanotation;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreanotation.beans.EmployeeBean;
import com.bcits.springcoreanotation.config.EmployeeConfig;

public class EmployeeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeBean employeeBean =  context.getBean(EmployeeBean.class);
		((ConfigurableApplicationContext)context).registerShutdownHook();

		
		System.out.print("Enter Employee1 Name  : ");
		employeeBean.setName(sc.nextLine());
		System.out.print("Enter Employee1 Age   : ");
		employeeBean.setAge(sc.nextInt());
		sc.nextLine();
		
		EmployeeBean employeeBean2 =  context.getBean(EmployeeBean.class);
		System.out.print("Enter Employee2 Name  : ");
		employeeBean2.setName(sc.nextLine());
		System.out.print("Enter Employee2 Age   : ");
		employeeBean2.setAge(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Employee Name  : "+employeeBean.getName());
		System.out.println("Employee Age   : "+employeeBean.getAge());
		System.out.println("-----------------------");
		System.out.println("Employee Name  : "+employeeBean2.getName());
		System.out.println("Employee Age   : "+employeeBean2.getAge());
	}
}
