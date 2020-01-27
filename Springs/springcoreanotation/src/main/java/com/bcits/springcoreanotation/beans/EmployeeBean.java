package com.bcits.springcoreanotation.beans;

import lombok.Data;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


@Data
public class EmployeeBean {
	private String name;
	private int age;
	@Autowired
	@Qualifier("hr")
	private DepartmentBean departmentBean;
	
	/*
	 * @PostConstruct 
	 * public void init() { 
	 * System.out.println("Its Init Phase");
	 *  }
	 * 
	 * @PreDestroy 
	 * public void destroy(){ 
	 * System.out.println("Its Distory Phase..");
	 * }
	 */
}
