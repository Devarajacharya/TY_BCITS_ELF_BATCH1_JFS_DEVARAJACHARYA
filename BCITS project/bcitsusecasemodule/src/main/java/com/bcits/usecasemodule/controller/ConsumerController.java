package com.bcits.usecasemodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.usecasemodule.service.ConsumerService;


@Controller
public class ConsumerController {
	
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
	public String addConsumerDetails() {
		return null;
	}
}
