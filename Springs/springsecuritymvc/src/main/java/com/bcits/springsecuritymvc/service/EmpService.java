package com.bcits.springsecuritymvc.service;

import java.util.List;

import com.bcits.springsecuritymvc.bean.EmployeeInfoBean;

public interface EmpService {
	public boolean register(EmployeeInfoBean employeeInfoBean);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployee();
}
