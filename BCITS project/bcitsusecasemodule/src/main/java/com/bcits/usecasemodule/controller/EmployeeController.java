package com.bcits.usecasemodule.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	@Autowired
	private EmployeeService service;
	@PostMapping("/employeeLogin")
	public String employeeLogin(int empId , String designation, ModelMap modelMap,HttpServletRequest req) {
	EmployeeMasterInfo empInfo = service.authentication(empId, designation);
	if(empInfo != null) {
		HttpSession session = req.getSession(true);
		session.setAttribute("msg", "You hava sucessfully logged in");
		return "employeeHomePage";
	} else {
		modelMap.addAttribute("errMsg", "Invalid Credential !!");
		return "employeeLoginPage";
	}
	}
	
	@GetMapping("/employeeLogout")
	public String employeeLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "You Are Sucessfully Logged Out !!");
		return "employeeLoginPage";
	}
}
