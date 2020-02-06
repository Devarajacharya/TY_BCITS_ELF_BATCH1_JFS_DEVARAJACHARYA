package com.bcits.springsecuritymvc.DAO;

import java.util.List;

import com.bcits.springsecuritymvc.bean.EmployeeInfoBean;

public interface EmpDAO {
	public boolean register(EmployeeInfoBean employeeInfoBean);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployee();
}
