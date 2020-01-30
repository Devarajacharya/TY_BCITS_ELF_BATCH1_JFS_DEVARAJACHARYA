package com.bcits.springboot.service;

import java.util.List;

import com.bcits.springboot.Beans.EmployeeInfoBean;

public interface EmployeeService {

	public EmployeeInfoBean authentication(int empId ,String password);
	public boolean addEmployee(EmployeeInfoBean empBean , String cpsw);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeInfoBean empBean);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployee();
}
