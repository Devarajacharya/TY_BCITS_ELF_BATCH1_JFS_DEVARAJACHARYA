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

import com.bcits.usecasemodule.bean.BillHistory;
import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.bean.MonthlyConsumption;
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
	
	@GetMapping("/empLoginPage")
	public String displayEmpLoginPage() {
		return "employeeLoginPage";
	}

	@PostMapping("/employeeLogin")
	public String employeeLogin(int empId, String password, ModelMap modelMap, HttpServletRequest req) {
		EmployeeMasterInfo empMasterInfo = service.authentication(empId, password);
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
			CurrentBill currentBill2 = service.addCurrentBill(currentBill,empMasterInfo.getRegion());
			if (currentBill2 != null) {
				modelMap.addAttribute("msg", "Bill Generated for RR Number " + currentBill.getRrNumber() + " Sucessfully..");
			} else {
				modelMap.addAttribute("errMsg", "This Month Bill is Already Generated " + currentBill.getRrNumber());
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

	@GetMapping("/complaintsDetails")
	public String diplayComplaitPage(ModelMap modelMap, HttpSession session) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			List<SupportBean> supportList = service.getComplaintsList(empMasterInfo.getRegion());
			if(supportList != null && !supportList.isEmpty()) {
				modelMap.addAttribute("support",supportList);
			}else {
				modelMap.addAttribute("errMsg","No Complaints Record.");
			}
			return "complaintsDetailsPage";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}
	
	@PostMapping("/sendResponse")
	public String addResponses(ModelMap modelMap, HttpSession session,String rrNumber,String response ,Date date) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			List<SupportBean> supportList = service.getComplaintsList(empMasterInfo.getRegion());
			modelMap.addAttribute("support",supportList);
			if(service.sendRespond(rrNumber,response,date)) {
				modelMap.addAttribute("msg","Sent");
			}
			return "complaintsDetailsPage";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
		
	}
	
	@GetMapping("/BillCollected")
	public String displayBillCollectedPage(ModelMap modelMap, HttpSession session) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			List<BillHistory> billHistoryList = service.getBillList(empMasterInfo.getRegion());
			if(billHistoryList != null && !billHistoryList.isEmpty()) {
				modelMap.addAttribute("billHistroy",billHistoryList);
			}else {
				modelMap.addAttribute("errMsg","No record is found.");
			}
			return "billCollected";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}
	
	@GetMapping("/billPending")
	public String displayBillCollected(ModelMap modelMap, HttpSession session) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			List<MonthlyConsumption> billList = service.getCollectedBill(empMasterInfo.getRegion());
			if(billList != null && !billList.isEmpty()) {
				modelMap.addAttribute("billList",billList);
			}else {
				modelMap.addAttribute("errMsg","No record is found.");
			}
			return "billPendingPage";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}
	
	@GetMapping("/showConsumer")
	public String diplayConsumerSearch(HttpSession session , ModelMap modelMap) {
		EmployeeMasterInfo empMasterInfo = (EmployeeMasterInfo) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			List<ConsumerInfoBean> consList = service.getAllConsumer(empMasterInfo.getRegion());
			modelMap.addAttribute("consumerList",consList);
			return "consumerDetailsPage";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}
}















