package com.bcits.usecasemodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.bean.SupportBean;
import com.bcits.usecasemodule.dao.EmployeeDAO;

@Service
public class EmployeeServiceImplimentation implements EmployeeService{

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public EmployeeMasterInfo authentication(int empId, String designation) {
		if(empId<1 && designation.isEmpty()) {
			return null;
		}
		return dao.authentication(empId, designation);
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
	public boolean addCurrentBill(CurrentBill currentBill) {
		if(currentBill != null ) {
			return dao.addCurrentBill(currentBill);
		}
		return false;
	}

	@Override
	public List<CurrentBill> getGeneratedBill(String region) {
		if(region != null) {
			return dao.getGeneratedBill(region);
		}
		return null;
	}

	@Override
	public List<SupportBean> getComplaints(String region) {
		if(region != null) {
			return dao.getComplaints(region);
		}
		return null;
	}

}