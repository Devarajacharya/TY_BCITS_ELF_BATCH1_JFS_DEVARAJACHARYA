package com.bcits.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.bcits.springboot.Beans.EmployeeInfoBean;
import com.bcits.springboot.dao.EmployeeDAO;
import com.bcits.springboot.exception.EmployeeException;

@Service
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
