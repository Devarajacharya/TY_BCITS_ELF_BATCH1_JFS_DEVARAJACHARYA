package com.bcits.usecasemodule.service;

import java.util.List;


import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.bean.SupportBean;

public interface EmployeeService {
	public EmployeeMasterInfo authentication(int empId , String password);
	public List<ConsumerInfoBean> getAllConsumer(String region);
	public long countConsumer(String region);
	public CurrentBill addCurrentBill(CurrentBill currentBill);
	public List<CurrentBill> getGeneratedBill(String region);
	public List<SupportBean> getComplaintsList(String region);
	public boolean sendRespond(String rrNumber, String response);


}
