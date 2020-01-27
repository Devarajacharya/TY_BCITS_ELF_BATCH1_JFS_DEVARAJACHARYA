package com.bcits.springcore.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
// @AllArgsConstructor
 public class EmployeeBean {

	private String name;
	private int age;
	private DepartmentBean deptBean;
	
	
	/*
	 * public EmployeeBean(String name, int age, DepartmentBean deptBean) {
	 * this.name = name; this.age = age; this.deptBean = deptBean; }
	 */
	 
}
