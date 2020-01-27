package com.bcits.springcoreanotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreanotation.beans.DepartmentBean;

@Configuration
public class Departmentconfig {
	@Bean(name="account")
	public DepartmentBean getDeptAccount() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptName("Accounting");
		departmentBean.setDeptNo(12);
		return departmentBean;
	}
	@Bean(name="hr")
//	@Primary
	public DepartmentBean getDeptHR() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptName("HR");
		departmentBean.setDeptNo(15);
		return departmentBean;
	}
	@Bean(name="test")
	public DepartmentBean getDeptTest() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptName("Testing");
		departmentBean.setDeptNo(18);
		return departmentBean;
	}
	
}
