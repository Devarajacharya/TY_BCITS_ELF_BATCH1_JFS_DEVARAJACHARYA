package com.bcits.springsecurityrest.DAO;

import java.util.List;

import com.bcits.springsecurityrest.beans.EmployeeInfoBean;

public interface EmpDAO {
	public boolean register(EmployeeInfoBean employeeInfoBean);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployee();
}
