package com.bcits.springsecurityrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springsecurityrest.beans.EmployeeInfoBean;
import com.bcits.springsecurityrest.beans.EmployeeResponse;
import com.bcits.springsecurityrest.service.EmpService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/getEmployee")
	public EmployeeResponse getEmployee(int empId) {
		EmployeeInfoBean empBean = service.getEmployee(empId);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		
		if(empBean != null) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("Success");
			employeeResponse.setDescription("Employee Record Found");
			employeeResponse.setEmpBean(empBean);
		}else {
			employeeResponse.setStatusCode(401);
			employeeResponse.setMessage("Failed");
			employeeResponse.setDescription("Employee Record Not Found !");
		}
		return employeeResponse;
	}
	
	@GetMapping("/getAllEmployee")
	public EmployeeResponse getAllEmployee() {
		List<EmployeeInfoBean> empList = service.getAllEmployee();
		EmployeeResponse employeeResponse = new EmployeeResponse();
		
		if(empList != null && !empList.isEmpty()) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("Success");
			employeeResponse.setDescription("Employee Data Found.");
			employeeResponse.setEmpList(empList);
			
		}else {
			employeeResponse.setStatusCode(401);
			employeeResponse.setMessage("Failed");
			employeeResponse.setDescription("No Record to Display !");
		}
		return employeeResponse;
	}

}
















