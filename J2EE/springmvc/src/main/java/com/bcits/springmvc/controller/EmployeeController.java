package com.bcits.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.springmvc.bean.EmployeeInfoBean;
import com.bcits.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service ;

	@GetMapping("/login")
	public String displayLoginPage() {
		return "employeeLoginForm";
	}

	@PostMapping("/login")
	public String authenticate(int empId, String password, ModelMap modelMap, HttpServletRequest req) {
		EmployeeInfoBean employeeInfoBean = service.authentication(empId, password);

		if (employeeInfoBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInEmp", employeeInfoBean);
			return "employeeHome";
		} else {
			modelMap.addAttribute("errMsg", "Invalid Credential ..!!");
			return "employeeLoginForm";
		}
	}

	@GetMapping("/searchEmpForm")
	public String displaySearchForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "employeeLoginForm";
		} else {
			return "searchEmpForm";
		}
	}

	@GetMapping("/search")
	public String searchEmployee(int empId, HttpSession session, ModelMap modelMap) {

		if (session.getAttribute("loggedInEmp") != null) {
			// valid
			EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);

			if (employeeInfoBean != null) {
				modelMap.addAttribute("employeeInfoBean", employeeInfoBean);
			} else {
				modelMap.addAttribute("errMsg", "Employee Id is Not Found..");
			}
			return "searchEmpForm";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginForm";
		}
	}

	@GetMapping("/deleteEmployee")
	public String displayDeleteEmpForm(
			@SessionAttribute(name = "loggedInEmp", required = false) EmployeeInfoBean emInfoBean, ModelMap modelMap) {
		if (emInfoBean != null) {
			return "deleteEmpForm";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginForm";
		}
	}

	@GetMapping("/delete")
	public String deleteEmployee(int empId, HttpSession session, ModelMap modelMap) {
		if (session.getAttribute("loggedInEmp") != null) {
			if (service.deleteEmployee(empId)) {
				modelMap.addAttribute("msg", "Employee Record deleted Sucessfully..");
			} else {
				modelMap.addAttribute("errMsg", "Employee Id is Not Found..");
			}
			return "deleteEmpForm";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginForm";
		}
	}
	
	@GetMapping("/logout")
	public String logoutEmployee(HttpSession session ,ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("errMsg","You Are Sucessfully Logged Out !!");
		return "employeeLoginForm";
	}
}
