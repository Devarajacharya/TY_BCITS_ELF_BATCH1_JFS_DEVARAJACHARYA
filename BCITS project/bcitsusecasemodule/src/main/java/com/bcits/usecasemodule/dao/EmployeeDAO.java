package com.bcits.usecasemodule.dao;

import com.bcits.usecasemodule.bean.EmployeeMasterInfo;

public interface EmployeeDAO {
	public EmployeeMasterInfo authentication(int empId , String designation);

}
