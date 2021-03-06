package com.bcits.springboot.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springboot.Beans.EmployeeInfoBean;
import com.bcits.springboot.Beans.EmployeeResponse;
import com.bcits.springboot.service.EmployeeService;

@RestController
//@Controller
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;

	@GetMapping(path = "/getEmployee/{emmployeeId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//	@ResponseBody
	public EmployeeResponse getEmployee(@PathVariable(name = "emmployeeId") int empId) {
		EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if(employeeInfoBean != null) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("Success");
			employeeResponse.setDescription("Employee Record Found for " +empId);
			employeeResponse.setEmployeeInfoBean(employeeInfoBean);
		}else {
			employeeResponse.setStatusCode(404);
			employeeResponse.setMessage("Failed");
			employeeResponse.setDescription("Employee Id not found!");
		}
		return employeeResponse;
	}

	@GetMapping(path = "/getAllEmployee", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getAllEmployee() {
		List<EmployeeInfoBean> employeeInfoBeans = service.getAllEmployee();
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if(employeeInfoBeans != null) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("Success");
			employeeResponse.setDescription("Record fetched Sucessfully");
			employeeResponse.setEmpList(employeeInfoBeans);
		}else {
			employeeResponse.setStatusCode(404);
			employeeResponse.setMessage("Failed");
			employeeResponse.setDescription("Unnable to fetch th record!!");
		}
		return employeeResponse;
	}

	@DeleteMapping(path = "/deleteEmployee", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse deleteEmployee(int empId) {
		boolean isdelete = service.deleteEmployee(empId);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if(isdelete) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("Success");
			employeeResponse.setDescription("Employee ID "+empId+" Deleted Sucessfully.");
		}else {
			employeeResponse.setStatusCode(404);
			employeeResponse.setMessage("Failed");
			employeeResponse.setDescription("Unnable to Delete the employee record!");
		}
		return employeeResponse;
	}
	
	@PostMapping(path="/addEmployee",
			consumes = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
	public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		boolean isAdded =  service.addEmployee(employeeInfoBean, "qwerty");
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if(isAdded) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("Success");
			employeeResponse.setDescription("Employee ID "+employeeInfoBean.getEmpid()+" added Sucessfully.");
		}else {
			employeeResponse.setStatusCode(404);
			employeeResponse.setMessage("Failed");
			employeeResponse.setDescription("Unnable to add the employee record!");
		}
		return employeeResponse;
	}
	
	@PutMapping(path="/updateEmployee" ,
			consumes = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean emInfoBean) {
		boolean isUpdated = service.updateEmployee(emInfoBean);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if(isUpdated) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("Success");
			employeeResponse.setDescription("Employee ID "+emInfoBean.getEmpid()+" Updated Sucessfully.");
		}else {
			employeeResponse.setStatusCode(404);
			employeeResponse.setMessage("Failed");
			employeeResponse.setDescription("Employee ID is not found!!!");
		}
		return employeeResponse;
	}

}
















