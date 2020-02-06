package com.bcits.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpringSecurityController {

	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/adminSecureHome")
	public String getAdminHomePage() {
		return "adminHomePage";
	}
	
	@GetMapping("/userSecurePage")
	public String getUserHomePage() {
		return "userHomePage";
	}

	@GetMapping("login")
	public String displyLoginForm() {
		return "LoginForm";
	}
}

