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

import com.bcits.usecasemodule.bean.AdminInfo;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.service.AdminService;



@Controller
public class AdminController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/displayLoginPage")
	public String displayLoginPage() {
		return "adminLoginPage";
	}
	
	@PostMapping("/adminLogin")
	public String adminLogin(HttpServletRequest req ,ModelMap modelMap ,String username,String password) {
		AdminInfo admin = service.authenticate(username, password);
		if(admin != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("admin", admin);
			return "adminHome";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "adminLoginPage";
		}
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(HttpSession session ,EmployeeMasterInfo employeeMasterInfo ,ModelMap modelMap) {
		AdminInfo adminInfo = (AdminInfo) session.getAttribute("admin");
		if(adminInfo != null) {
			if(service.addEMployee(employeeMasterInfo)) {
				modelMap.addAttribute("msg","Employee Added Sucessfully.");
			}else {
				modelMap.addAttribute("errMsg","Failed to add Employee!!");
			}
			return "adminHome";
		}else {
			modelMap.addAttribute("errMsg", "Login First!!");
			return "adminLoginPage";
		}
	}
	
	@GetMapping("/logOut")
	public String logOut(HttpSession session ,ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "You Are Sucessfully Logged Out !!");
		return "adminLoginPage";
	}
}
