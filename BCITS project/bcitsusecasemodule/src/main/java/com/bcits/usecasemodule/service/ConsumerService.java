package com.bcits.usecasemodule.service;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;

public interface ConsumerService {

	public boolean addConsumer(ConsumerInfoBean conInfoBean , String cnfPassword);
	public ConsumerInfoBean authentication(String rrNumber, String password);

}
