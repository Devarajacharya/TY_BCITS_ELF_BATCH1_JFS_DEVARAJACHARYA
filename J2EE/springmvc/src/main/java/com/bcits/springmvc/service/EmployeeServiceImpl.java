package com.bcits.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springmvc.bean.EmployeeInfoBean;
import com.bcits.springmvc.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public EmployeeInfoBean authentication(int empId, String password) {
		return dao.authentication(empId, password);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean empBean) {
		return  dao.addEmployee(empBean);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		if(empId < 1) {
			return false;
		}
		return  dao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean empBean) {
		return  dao.updateEmployee(empBean);
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		return  dao.getEmployee(empId);
	}

	@Override
	public List<EmployeeInfoBean> getAllEMployee() {
		return  dao.getAllEMployee();
	}

}
