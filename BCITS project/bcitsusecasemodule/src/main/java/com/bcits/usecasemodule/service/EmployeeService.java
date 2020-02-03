package com.bcits.usecasemodule.service;

import java.util.List;


import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;

public interface EmployeeService {
	public EmployeeMasterInfo authentication(int empId , String designation);
	public List<ConsumerInfoBean> getAllConsumer(String region);
	public long countConsumer(String region);
}
