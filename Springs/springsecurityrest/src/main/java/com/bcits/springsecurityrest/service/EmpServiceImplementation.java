package com.bcits.springsecurityrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bcits.springsecurityrest.DAO.EmpDAO;
import com.bcits.springsecurityrest.beans.EmployeeInfoBean;

@Service
public class EmpServiceImplementation implements EmpService{
	
	@Autowired
	private EmpDAO dao;
	
	@Autowired
	private PasswordEncoder PasswordEncoder;
	
	@Override
	public boolean register(EmployeeInfoBean employeeInfoBean) {
		
		if(employeeInfoBean != null) {
			employeeInfoBean.setPassword(PasswordEncoder.encode(employeeInfoBean.getPassword()));
		}
		return dao.register(employeeInfoBean);
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		return dao.getEmployee(empId);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		return dao.getAllEmployee();
	}

}
