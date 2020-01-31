package com.bcits.usecasemodule.service;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;

public interface ConsumerService {

	public boolean addConsumer(ConsumerInfoBean conInfoBean , String cnfPassword);
	public ConsumerInfoBean authentication(String rrNumber, String password);
	public CurrentBill getCurrentBill(String rrNumber);

}
