package com.bcits.usecasemodule.dao;

import com.bcits.usecasemodule.bean.AdminInfo;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;

public interface AdminDAO {
	public AdminInfo authenticate(String username, String password);
	public boolean addEMployee(EmployeeMasterInfo empInfo);
}
