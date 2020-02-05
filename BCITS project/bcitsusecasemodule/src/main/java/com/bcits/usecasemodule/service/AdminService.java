package com.bcits.usecasemodule.service;

import com.bcits.usecasemodule.bean.AdminInfo;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;

public interface AdminService {
	public AdminInfo authenticate(String username, String password);
	public boolean addEMployee(EmployeeMasterInfo empInfo);

}
