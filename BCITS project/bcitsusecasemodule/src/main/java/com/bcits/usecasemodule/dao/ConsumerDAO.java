package com.bcits.usecasemodule.dao;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;

public interface ConsumerDAO {
	
	public boolean addConsumer(ConsumerInfoBean conInfoBean);
	public ConsumerInfoBean authentication(String rrNumber, String password);
	public CurrentBill getCurrentBill(String rrNumber);


}
