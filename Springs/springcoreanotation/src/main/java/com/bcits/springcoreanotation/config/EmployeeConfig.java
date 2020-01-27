package com.bcits.springcoreanotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bcits.springcoreanotation.beans.EmployeeBean;

@Configuration

public class EmployeeConfig {
	@Bean
//	@Scope("prototype")
	public EmployeeBean getEmployeeBean() {
		/*
		 * EmployeeBean employeeBean = new EmployeeBean();
		 * employeeBean.setName("Ninja"); 
		 * employeeBean.setAge(23); 
		 * return employeeBean;
		 */
		return new EmployeeBean();
	}
}
