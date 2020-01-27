package com.bcits.springmvc.dao;

import java.util.List;

import com.bcits.springmvc.bean.EmployeeInfoBean;

public interface EmployeeDAO {
	public EmployeeInfoBean authentication(int empId ,String password);
	public boolean addEmployee(EmployeeInfoBean empBean);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeInfoBean empBean);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployee();
}
