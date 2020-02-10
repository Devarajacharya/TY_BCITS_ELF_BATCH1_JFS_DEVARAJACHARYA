package com.bcits.usecasemodule.service;

import java.util.List;

import com.bcits.usecasemodule.bean.AdminInfo;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;

public interface AdminService {
	public AdminInfo authenticate(String username, String password);
	public boolean addEMployee(EmployeeMasterInfo empInfo);
	public List<EmployeeMasterInfo> getAllEmployee();
	public boolean deleteEmployee(int empId);

}
