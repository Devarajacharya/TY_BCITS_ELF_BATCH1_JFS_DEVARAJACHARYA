package com.bcits.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDeligationController {
	
	@GetMapping("/redirect")
	public String redirectRequest() {
		return "redirect:https://GitHub.com";
	}
	
	@GetMapping("/forword")
	public String forwordRequest() {
		
		return "forword:login1";
	}
}
