package com.bcits.usecasemodule.service;

import java.util.List;


import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.bean.SupportBean;

public interface EmployeeService {
	public EmployeeMasterInfo authentication(int empId , String designation);
	public List<ConsumerInfoBean> getAllConsumer(String region);
	public long countConsumer(String region);
	public boolean addCurrentBill(CurrentBill currentBill);
	public List<CurrentBill> getGeneratedBill(String region);
	public List<SupportBean> getComplaints(String region);


}
