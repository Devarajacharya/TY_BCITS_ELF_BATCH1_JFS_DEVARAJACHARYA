package com.bcits.usecasemodule.dao;

import java.util.Date;
import java.util.List;

import com.bcits.usecasemodule.bean.BillHistory;
import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.bean.MonthlyConsumption;
import com.bcits.usecasemodule.bean.SupportBean;

public interface EmployeeDAO {
	public EmployeeMasterInfo authentication(int empId , String password);
	public List<ConsumerInfoBean> getAllConsumer(String region);
	public long countConsumer(String region);
	public CurrentBill addCurrentBill(CurrentBill currentBill,String region);
	public List<CurrentBill> getGeneratedBill(String region);	
	public List<SupportBean> getComplaintsList(String region);
	public boolean sendRespond(String rrNumber,String response ,Date date);
	public  List<MonthlyConsumption> getCollectedBill(String region);
	public List<BillHistory> getBillList(String region);
	public List<Object[]> monthlyRevenueCollected(String region);
	public List<Object[]> monthlyRevenuePending(String region);
	public List<Object[]> totalRevenue(String region);
}
