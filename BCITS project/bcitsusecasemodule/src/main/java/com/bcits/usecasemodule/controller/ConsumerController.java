package com.bcits.usecasemodule.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.service.ConsumerService;


@Controller
public class ConsumerController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	@Autowired
	private ConsumerService service;
	
	@GetMapping("/discomHomePage")
	public String dispalyHomePage() {
		return "homePage";
	}
	
	@GetMapping("/empLoginPage")
	public String displayEmpLoginPage() {
		return "employeeLoginPage";
	}
	
	@GetMapping("/consLoginPage")
	public String displayConsumerLoginPage() {
		return "consumerLoginPage";
	}
	
	@GetMapping("/signUpPage")
	public String displaySignUpPage() {
		return "consumerSignUpPage";
	}
	
	@PostMapping("/addConsumer")
	public String addConsumerDetails(ConsumerInfoBean conInfoBean ,ModelMap modelMap ,String cnfPassword) {
		if(service.addConsumer(conInfoBean , cnfPassword)) {
			modelMap.addAttribute("msg", "You have signed up sucessfully");
			return "consumerLoginPage";
	}else {
		modelMap.addAttribute("errMsg", "Sign Up failed");
		return "consumerSignUpPage";
	}
	}
}
