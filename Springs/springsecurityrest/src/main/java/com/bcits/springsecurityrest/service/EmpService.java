package com.bcits.springsecurityrest.service;

import java.util.List;

import com.bcits.springsecurityrest.beans.EmployeeInfoBean;

public interface EmpService {
	public boolean register(EmployeeInfoBean employeeInfoBean);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployee();
}
