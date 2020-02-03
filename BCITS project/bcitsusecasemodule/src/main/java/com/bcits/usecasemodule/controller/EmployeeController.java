package com.bcits.usecasemodule.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
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

	@GetMapping("/empLoginPage")
	public String displayEmpLoginPage() {
		return "employeeLoginPage";
	}

	@PostMapping("/employeeLogin")
	public String employeeLogin(int empId, String designation, ModelMap modelMap, HttpServletRequest req) {
		EmployeeMasterInfo empMasterInfo = service.authentication(empId, designation);
		long count = service.countConsumer(empMasterInfo.getRegion());
		List<ConsumerInfoBean> consList = service.getAllConsumer(empMasterInfo.getRegion());
		if (empMasterInfo != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInEmp", empMasterInfo);
			if (consList != null) {
				modelMap.addAttribute("count", count);
				modelMap.addAttribute("consumerList", consList);
			} else {
				modelMap.addAttribute("errMsg", "Unable to process the request");
			}
		} else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
			
		return "employeeHomePage";
	}

	@GetMapping("/employeeLogout")
	public String employeeLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "You Are Sucessfully Logged Out !!");
		return "employeeLoginPage";
	}

	@GetMapping("/getConsumer")
	public String getAllConsumer(ModelMap modelMap, HttpSession session) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if (empMasterInfo != null) {
			List<ConsumerInfoBean> consList = service.getAllConsumer(empMasterInfo.getRegion());
			if (consList != null) {
				modelMap.addAttribute("consumerList", consList);
				return "empGetAllConsumer";
			} else {
				modelMap.addAttribute("errMsg", "Unable to process the request");
				return "";
			}
		} else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}
	
	@GetMapping("/displayBillPage")
	public String dispalyBillGeneratorPage(ModelMap modelMap ,HttpSession session) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			return "billGenerator";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}
}
