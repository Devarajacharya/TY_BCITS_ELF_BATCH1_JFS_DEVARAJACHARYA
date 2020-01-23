package com.bcits.springcoreanotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.bcits.springcoreanotation.beans.DepartmentBean;
import com.bcits.springcoreanotation.beans.EmployeeBean;

@Configuration
@Import(Departmentconfig.class)
public class EmployeeConfig2 {
	@Bean
	public EmployeeBean getEmployeeBean() {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setName("Rishav");
		employeeBean.setAge(28);
//		employeeBean.setDepartmentBean(getDepartmentBean());
		return employeeBean;
	}
	
}
