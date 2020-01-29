package com.bcits.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bcits.springrest.beans.EmployeeInfoBean;
import com.bcits.springrest.customexception.EmployeeException;
import com.bcits.springrest.dao.EmployeeDAO;

@Service
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfoBean authentication(int empId, String password) {
		return dao.authentication(empId, password);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean empBean , String cpsw) {
		if(!empBean.getPassword().equals(cpsw)) {
			throw new EmployeeException("Password Miss Match!!");
		}
		return dao.addEmployee(empBean);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		if (empId < 1) {
			throw new EmployeeException("Invalid Employee Id");
		}
		return dao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean empBean) {
		if (empBean == null) {
			throw new EmployeeException("Failed to update a Employee record!!nm");
		}
		return dao.updateEmployee(empBean);
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		if (empId < 1) {
			throw new EmployeeException("Invalid Employee Id");
		}
		return dao.getEmployee(empId);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		return dao.getAllEmployee();
	}

}
