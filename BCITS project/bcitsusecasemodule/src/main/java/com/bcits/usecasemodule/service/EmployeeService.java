package com.bcits.usecasemodule.service;

import org.springframework.stereotype.Service;

import com.bcits.usecasemodule.bean.EmployeeMasterInfo;

public interface EmployeeService {
	public EmployeeMasterInfo authentication(int empId , String designation);
}
