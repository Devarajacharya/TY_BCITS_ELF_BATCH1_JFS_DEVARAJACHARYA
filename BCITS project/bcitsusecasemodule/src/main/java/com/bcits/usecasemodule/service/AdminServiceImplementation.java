package com.bcits.usecasemodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecasemodule.bean.AdminInfo;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.dao.AdminDAO;
import com.bcits.usecasemodule.validation.EmployeeValidationForm;
import com.bcits.usecasemodule.validation.FormValidation;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminDAO dao;

	@Override
	public AdminInfo authenticate(String username, String password) {
		return dao.authenticate(username, password);
	}

	@Override
	public boolean addEMployee(EmployeeMasterInfo empInfo) {
		if (EmployeeValidationForm.nameValidation(empInfo.getEmpName())
				|| EmployeeValidationForm.empIdValidation(empInfo.getEmpId())
				|| EmployeeValidationForm.regionValidation(empInfo.getRegion())
				|| EmployeeValidationForm.designationValidation(empInfo.getDesignation())
				|| EmployeeValidationForm.designationValidation(empInfo.getPassword())) {
			return false;
		}
		return dao.addEMployee(empInfo);
	}

	@Override
	public List<EmployeeMasterInfo> getAllEmployee() {
		return dao.getAllEmployee();
	}

	@Override
	public boolean deleteEmployee(int empId) {
		if (EmployeeValidationForm.empIdValidation(empId)) {
			return false;
		}
		return dao.deleteEmployee(empId);
	}

}
