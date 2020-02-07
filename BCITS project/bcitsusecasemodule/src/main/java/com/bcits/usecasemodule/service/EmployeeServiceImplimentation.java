package com.bcits.usecasemodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.bean.SupportBean;
import com.bcits.usecasemodule.dao.EmployeeDAO;
import com.bcits.usecasemodule.validation.FormValidation;

@Service
public class EmployeeServiceImplimentation implements EmployeeService{

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public EmployeeMasterInfo authentication(int empId, String password) {
		if(empId<1 && password.isEmpty()) {
			return null;
		}
		return dao.authentication(empId, password);
	}
	
	@Override
	public List<ConsumerInfoBean> getAllConsumer(String region) {
		return dao.getAllConsumer(region);
	}
	
	@Override
	public long countConsumer(String region) {
		return dao.countConsumer(region);
	}

	@Override
	public CurrentBill addCurrentBill(CurrentBill currentBill) {
		if(currentBill != null ) {
			return dao.addCurrentBill(currentBill);
		}
		return null;
	}

	@Override
	public List<CurrentBill> getGeneratedBill(String region) {
		if(region != null) {
			return dao.getGeneratedBill(region);
		}
		return null;
	}

	@Override
	public List<SupportBean> getComplaintsList(String region) {
		if(region != null) {
			return dao.getComplaintsList(region);
		}
		return null;
	}

	@Override
	public boolean sendRespond(String rrNumber, String response) {
		if(FormValidation.rrValidation(rrNumber)) {
			return false;
		}
		return dao.sendRespond(rrNumber,response);
	}

}