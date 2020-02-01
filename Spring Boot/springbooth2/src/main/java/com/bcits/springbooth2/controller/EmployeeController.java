package com.bcits.springbooth2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springbooth2.beans.EmployeeInfoBean;
import com.bcits.springbooth2.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping(path = "/getEmployee" 
			,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeInfoBean getEmployee(int empId) {
		Optional<EmployeeInfoBean> emOptional = repository.findById(empId);
		if(emOptional.isPresent()) {
			return emOptional.get();
		}else {
			return null;
		}
		
	}
	
	@PostMapping(path = "/addEmployee" ,
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} ,
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeInfoBean addEmployee(@RequestBody EmployeeInfoBean empBean) {
		EmployeeInfoBean employeeInfoBean = repository.save(empBean);
		return employeeInfoBean;
	}
	
	@PutMapping(path = "/updateEmployee" ,
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} ,
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeInfoBean updateEmployee(@RequestBody EmployeeInfoBean empBean) {
		EmployeeInfoBean employeeInfoBean = repository.save(empBean);
		return employeeInfoBean;
	}
	
	@DeleteMapping(path = "/deleteEmployee" ,
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} ,
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public boolean deleteEmployee(int empId) {
		try {
		repository.deleteById(empId);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}
