package com.bcits.usecasemodule.service;

import java.util.Date;
import java.util.List;

import com.bcits.usecasemodule.bean.BillHistory;
import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.MonthlyConsumption;
import com.bcits.usecasemodule.bean.SupportBean;

public interface ConsumerService {

	public boolean addConsumer(ConsumerInfoBean conInfoBean , String cnfPassword);
	public ConsumerInfoBean authentication(String rrNumber, String password);
	public CurrentBill getCurrentBill(String rrNumber);
	public List<BillHistory> getBillHistory(String rrNumber);
	public List<MonthlyConsumption> getMonthlyConsumptions(String rrNumber);
	public boolean billPayment(String rrNumber, Date date, double amount);
	public boolean changePassword(String password, String confPassword,String rrNumber);
	public ConsumerInfoBean getConsumer(String rrNumber);
	public long getPreviousReading(String rrNumber);
	public boolean setRequestMsg(String request ,String rrNumber, String region);
	public List<SupportBean> getResponse(String rrNumber);


}
