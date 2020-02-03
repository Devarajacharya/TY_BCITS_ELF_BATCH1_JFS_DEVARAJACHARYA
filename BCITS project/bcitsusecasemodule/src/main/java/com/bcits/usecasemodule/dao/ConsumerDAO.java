package com.bcits.usecasemodule.dao;

import java.util.Date;
import java.util.List;

import com.bcits.usecasemodule.bean.BillHistory;
import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.MonthlyConsumption;

public interface ConsumerDAO {
	
	public boolean addConsumer(ConsumerInfoBean conInfoBean);
	public ConsumerInfoBean authentication(String rrNumber, String password);
	public CurrentBill getCurrentBill(String rrNumber);
	public List<BillHistory> getBillHistory(String rrNumber);
	public List<MonthlyConsumption> getMonthlyConsumptions(String rrNumber);
	public boolean billPayment(String rrNumber, Date date, double amount);

}
