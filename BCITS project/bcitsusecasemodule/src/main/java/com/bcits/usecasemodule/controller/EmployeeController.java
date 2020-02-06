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
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.bean.SupportBean;
import com.bcits.usecasemodule.mail.MailGenerator;
import com.bcits.usecasemodule.service.ConsumerService;
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
	@Autowired
	private ConsumerService consumerService;
	
	
	private MailGenerator mail = new MailGenerator();

	@GetMapping("/empLoginPage")
	public String displayEmpLoginPage() {
		return "employeeLoginPage";
	}

	@PostMapping("/employeeLogin")
	public String employeeLogin(int empId, String designation, ModelMap modelMap, HttpServletRequest req) {
		EmployeeMasterInfo empMasterInfo = service.authentication(empId, designation);
		long count = service.countConsumer(empMasterInfo.getRegion());
		if (empMasterInfo != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInEmp", empMasterInfo);
			modelMap.addAttribute("count", count);
			return "employeeHome";
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

	@GetMapping("/getConsumer")
	public String getAllConsumer(ModelMap modelMap, HttpSession session) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if (empMasterInfo != null) {
			List<ConsumerInfoBean> consList = service.getAllConsumer(empMasterInfo.getRegion());
			if (consList != null) {
				modelMap.addAttribute("consumerList", consList);
			} else {
				modelMap.addAttribute("errMsg", "Unable to process the request");
			}
			return "showAllConsumer";
		} else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}

	@GetMapping("/displayBillPage")
	public String dispalyBillGeneratorPage(ModelMap modelMap, HttpSession session, String rrNumber) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if (empMasterInfo != null) {
			consumerService.getMonthlyConsumptions(rrNumber);
			ConsumerInfoBean conInfoBean = consumerService.getConsumer(rrNumber);
			long previous = consumerService.getPreviousReading(rrNumber);
			if (conInfoBean != null) {
				modelMap.addAttribute("consumerBean", conInfoBean);
				modelMap.addAttribute("prev", previous);
			}
		} else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
		return "billGenerator";
	}

	@GetMapping("/generateBill")
	public String generateBill(ModelMap modelMap, HttpSession session, CurrentBill currentBill) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if (empMasterInfo != null) {
			List<ConsumerInfoBean> consList = service.getAllConsumer(empMasterInfo.getRegion());
			modelMap.addAttribute("consumerList", consList);
			CurrentBill currentBill2 = service.addCurrentBill(currentBill);
			if (currentBill2 != null) {
				mail.sendMail(currentBill2);
				modelMap.addAttribute("msg", "Bill Generated for RR Number " + currentBill.getRrNumber() + " Sucessfully..");
			} else {
				modelMap.addAttribute("errMsg", "This Month Bill is Already Generated" + currentBill.getRrNumber());
			}
			return "showAllConsumer";
		} else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}

	}

	@GetMapping("/displayEmpHome")
	public String dispalyEmployeeHome(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "employeeLoginPage";
		} else {
			EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
			long count = service.countConsumer(empMasterInfo.getRegion());
			modelMap.addAttribute("count", count);
			return "employeeHome";
		}
	}
	
	@GetMapping("/generatedBill")
	public String displayGeneratedBill(ModelMap modelMap, HttpSession session) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
		List<CurrentBill> currentBill = service.getGeneratedBill(empMasterInfo.getRegion());
		if(currentBill != null) {
			modelMap.addAttribute("generatedBill",currentBill);
		}else {
			modelMap.addAttribute("errMsg", "No Record is found.!");
		}
		return "generatedBillPage";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}
	
	@GetMapping("/complaintsDetails")
	public String diplayComplaitPage(ModelMap modelMap, HttpSession session) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			List<SupportBean> supportList = service.getComplaints(empMasterInfo.getRegion());
			if(supportList != null) {
				modelMap.addAttribute("support",supportList);
			}else {
				modelMap.addAttribute("errMsg","No Querys found..");
			}
			return "complaintsDetailsPage";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}
}



