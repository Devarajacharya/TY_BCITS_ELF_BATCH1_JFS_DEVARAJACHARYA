package com.bcits.usecasemodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecasemodule.bean.AdminInfo;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.dao.AdminDAO;

@Service
public class AdminServiceImplementation implements AdminService{
	
	@Autowired
	private AdminDAO dao;
	@Override
	public AdminInfo authenticate(String username, String password) {
		return dao.authenticate(username, password);
	}
	@Override
	public boolean addEMployee(EmployeeMasterInfo empInfo) {
		if(empInfo != null) {
			return dao.addEMployee(empInfo);
		}
		return false;
	}

}
