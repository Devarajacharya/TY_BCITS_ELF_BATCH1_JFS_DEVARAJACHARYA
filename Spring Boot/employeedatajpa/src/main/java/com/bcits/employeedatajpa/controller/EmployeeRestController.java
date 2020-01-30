package com.bcits.employeedatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.employeedatajpa.bean.EmployeeInfoBean;
import com.bcits.employeedatajpa.bean.EmployeeResponse;
import com.bcits.employeedatajpa.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping(path = "/getEmp", produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
	public EmployeeResponse getEmployee(int empId) {
		EmployeeResponse repResponse = new EmployeeResponse();
		EmployeeInfoBean employeeInfoBean = null;
		try {
		employeeInfoBean = repository.findById(empId).get();
		}catch (Exception e) {
			repResponse.setStatusCode(404);
			repResponse.setMessage("Exception");
			repResponse.setDescription("Invalid Employee Id !!");
		}
		if(employeeInfoBean != null) {
			repResponse.setStatusCode(202);
			repResponse.setMessage("Success");
			repResponse.setDescription("Employee Record Found + "+empId);
			repResponse.setEmployeeInfoBean(employeeInfoBean);
		}else {
			repResponse.setStatusCode(404);
			repResponse.setMessage("Failed");
			repResponse.setDescription("Employee ID not found ");
		}
		return repResponse;
	}
	
	@GetMapping(path = "/getEmpById", produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
	public EmployeeResponse findById(int empId ,String password) {
		EmployeeResponse repResponse = new EmployeeResponse();
		EmployeeInfoBean employeeInfoBean = null;
		try {
			employeeInfoBean = repository.findByIdAndPassword(empId, password);
		}catch (Exception e) {
			repResponse.setStatusCode(404);
			repResponse.setMessage("Exception");
			repResponse.setDescription("Invalid Employee Id/Password!!");
		}
		if( employeeInfoBean != null) {
			repResponse.setStatusCode(202);
			repResponse.setMessage("Success");
			repResponse.setDescription("Employee Record Found + "+empId);
			repResponse.setEmployeeInfoBean(employeeInfoBean);

		}else {
			repResponse.setStatusCode(404);
			repResponse.setMessage("Failed");
			repResponse.setDescription("Employee ID not found ");
		}
		return repResponse;
	}
}
