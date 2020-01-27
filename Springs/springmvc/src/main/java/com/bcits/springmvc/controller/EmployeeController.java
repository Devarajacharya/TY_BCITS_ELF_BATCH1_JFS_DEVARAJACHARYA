package com.bcits.springmvc.controller;

import java.util.List;

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
	private EmployeeService service;

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
	public String logoutEmployee(HttpSession session, ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "You Are Sucessfully Logged Out !!");
		return "employeeLoginForm";
	}

	@GetMapping("/seeAllEmployee")
	public String getAllEmployeeInfo(
			@SessionAttribute(name = "loggedInEmp", required = false) EmployeeInfoBean empInfoBean, ModelMap modelMap) {
		if (empInfoBean != null) {
			List<EmployeeInfoBean> empInfoList = service.getAllEmployee();
			modelMap.addAttribute("allEmpDetails", empInfoList);
			return "getAllEmpForm";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginForm";
		}
	}

	@GetMapping("/addEmpForm")
	public String displayAddEmpForm(
			@SessionAttribute(name = "loggedInEmp", required = false) EmployeeInfoBean emInfoBean, ModelMap modelMap) {
		if (emInfoBean != null) {
			return "addEmpForm";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginForm";
		}
	}

	@PostMapping("/addEmployee")
	public String addEmpRecordForm(HttpSession session, ModelMap modelMap , EmployeeInfoBean empBean) {
		if (session.getAttribute("loggedInEmp") != null) {
			if(service.addEmployee(empBean)) {
				modelMap.addAttribute("employeeInfoBean", empBean);
			}else {
				modelMap.addAttribute("errMsg", "Failed to Insert the Employee Record..");
				return "addEmpForm";
			}
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginForm";
		}
		return "showEmpDetail";	
	}

	@GetMapping("/updateEmployee")
	public String displayUpdateEmpForm(
			@SessionAttribute(name = "loggedInEmp", required = false) EmployeeInfoBean empInfoBean, ModelMap modelMap) {
		if (empInfoBean != null) {
			return "updateEmpForm";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginForm";
		}
	}

	@PostMapping("/updateEmpForm")
	public String updateEmpForm(EmployeeInfoBean empBean,
			@SessionAttribute(name = "loggedInEmp", required = false) EmployeeInfoBean empInfoBean, ModelMap modelMap) {
		if (empInfoBean != null) {
			if (service.updateEmployee(empBean)) {
				modelMap.addAttribute("msg", "Employee Record Updated Sucessfully..");
			} else {
				modelMap.addAttribute("errMsg", "Employee Id is Not Found..");
			}
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginForm";
		}
		return "updateEmpForm";
	}
}
