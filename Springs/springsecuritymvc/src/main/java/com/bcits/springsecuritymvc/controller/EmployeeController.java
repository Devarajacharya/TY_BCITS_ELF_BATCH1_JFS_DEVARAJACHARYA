package com.bcits.springsecuritymvc.controller;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.springsecuritymvc.bean.EmployeeInfoBean;
import com.bcits.springsecuritymvc.service.EmpService;

@Controller
public class EmployeeController {
	@Autowired
	private EmpService service;
	
	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}//End of getIndexPage
	
	@GetMapping("/register")
	public String getRegisterPage() {
		return "Register";
	}//End Of getRegisterPage
	
	@PostMapping("/register")
	public String getRegister(EmployeeInfoBean emInfoBean,ModelMap modelMap) {
		boolean isRegister = service.register(emInfoBean);
		if(isRegister) {
			modelMap.addAttribute("msg" ,"Registered Sucessfully...");
		}else {
			modelMap.addAttribute("errMsg" ,"Registeration Failed...");
		}
		return "Register";
	}//End of register();
	
	@GetMapping("/adminSecureHome")   
	public String getAdminHome() {
		return "adminHomePage";
	}
	
	@GetMapping("/userSecurePage")   
	public String getUserHome() {
		return "userHomePage";
	}
	
	
	
	@GetMapping("/getEmployee")
	public String getEmployeeForm() {
		return "search";
	}
	
	@GetMapping("/getEmp")
	public String getEmployee(int empId , ModelMap modelMap) {
		EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
		if(employeeInfoBean != null ) {
			modelMap.addAttribute("empBean",employeeInfoBean);
		}else {
			modelMap.addAttribute("errMsg","No Employee Found..");
		}
		return "search";

	}
	
	@GetMapping("/getAllEmployee")
	public String getAllEmp( ModelMap modelMap) {
		modelMap.addAttribute("listEmp", service.getAllEmployee());
		return "getAllEmployeePage";
	}
	
	
} //End Of Controller
