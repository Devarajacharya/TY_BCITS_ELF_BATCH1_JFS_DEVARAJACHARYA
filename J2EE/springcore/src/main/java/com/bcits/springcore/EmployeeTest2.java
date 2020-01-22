package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;

public class EmployeeTest2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("employeeConfig.xml");
		EmployeeBean empBean = context.getBean("employee", EmployeeBean.class);
		
		System.out.println("Name      : "+empBean.getName());
		System.out.println("Age       : "+empBean.getAge());
		System.out.println("Dept No   : "+empBean.getDeptBean().getDeptId());
		System.out.println("Dept Name : "+empBean.getDeptBean().getDeptName());
	}

}
