package com.bcits.usecasemodule.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
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
import com.bcits.usecasemodule.bean.MonthlyConsumption;
import com.bcits.usecasemodule.bean.SupportBean;
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

	@GetMapping("/consLoginPage")
	public String displayConsumerLoginPage() {
		return "consumerLoginPage";
	}

	@GetMapping("/signUpPage")
	public String displaySignUpPage() {
		return "consumerSignUpPage";
	}

	@GetMapping("/failedConsumer")
	public String displayFailedConsumer() {
		return "consumerFailedPage";
	}

	@PostMapping("/addConsumer")
	public String addConsumerDetails(ConsumerInfoBean conInfoBean, ModelMap modelMap, String cnfPassword) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		conInfoBean.setSignupDate(formatter.format(new Date()));
		if (service.addConsumer(conInfoBean, cnfPassword)) {

			modelMap.addAttribute("msg", "You have signed up sucessfully");
			return "consumerLoginPage";
		} else {
			modelMap.addAttribute("errMsg", "Sign Up failed");
			return "consumerSignUpPage";
		}
	}

	@PostMapping("/consumerLogin")
	public String consumerLogin(String email, String password, HttpServletRequest req, ModelMap modelMap) {
		ConsumerInfoBean consumerInfoBean = service.authentication(email, password);
		if (consumerInfoBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInCons", consumerInfoBean);
			return "consumerHomePage";
		} else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "consumerLoginPage";
		}
	}

	@GetMapping("/consumerLogout")
	public String consumerLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "You Are Sucessfully Logged Out !!");
		return "consumerLoginPage";
	}

	@GetMapping("/consumerPaymentPage")
	public String dispalyPaymentPage(HttpSession session, ModelMap modelMap) {
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInCons");
		if (consumerInfoBean != null) {
			CurrentBill currentBill = service.getCurrentBill(consumerInfoBean.getRrNumber());
			if (currentBill != null) {
				if (currentBill.getStatus().equals("Not Paid")) {
					modelMap.addAttribute("currentBill", currentBill);
					return "paymentPage";
				} else {
					modelMap.addAttribute("errMsg", "This month bill is already paid.!");
				}
			} else {
				modelMap.addAttribute("errMsg", "No Current Bill found for Payment.!");
			}
			return "consumerFailedPage";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}

	@PostMapping("/successfullPaymentPage")
	public String displaySucessfullPaymentPage(HttpSession session, ModelMap modelMap, double amount) {
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInCons");
		Date date = new Date();
		if (consumerInfoBean != null) {
			if (service.billPayment(consumerInfoBean.getRrNumber(), date, amount, consumerInfoBean.getRegion())) {
				return "paymentSuccessfullPage";
			} else {
				modelMap.addAttribute("errMsg", "Unable to Proccess try again Later.!!");
				return "consumerFailedPage";
			}
		} else {
			return "consumerLoginPage";
		}
	}

	@GetMapping("/displayConsumerHome")
	public String displayConsumerHomePage(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerLoginPage";
		} else {
			return "consumerHomePage";
		}
	}

	@GetMapping("/displayMonthlyConsumptionPage")
	public String displayMonthlyConsumptionPage(HttpSession session, ModelMap modelMap) {
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInCons");
		if (consumerInfoBean != null) {
			List<MonthlyConsumption> monthlyConsumption = service
					.getMonthlyConsumptions(consumerInfoBean.getRrNumber());
			if (monthlyConsumption != null && !monthlyConsumption.isEmpty()) {
				modelMap.addAttribute("monthlyCons", monthlyConsumption);
				return "monthlyConsumptionPage";
			} else {
				modelMap.addAttribute("errMsg", "No monthly consumption is found to display.!!");
				return "consumerFailedPage";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}

	@GetMapping("/displayBillHistorysPage")
	public String displayBillHistoryPage(HttpSession session, ModelMap modelMap) {
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInCons");
		if (consumerInfoBean != null) {
			List<BillHistory> billHistory = service.getBillHistory(consumerInfoBean.getRrNumber());
			if (billHistory != null && !billHistory.isEmpty()) {
				modelMap.addAttribute("billHistory", billHistory);
				return "billHistoryPage";
			} else {
				modelMap.addAttribute("errMsg", "No Bill History is found to display.!!");
				return "consumerFailedPage";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}


	@PostMapping("/getQuery")
	public String getQuery(HttpSession session, ModelMap modelMap, String request) {
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInCons");
		if (consumerInfoBean != null) {
			if (service.setRequestMsg(request, consumerInfoBean.getRrNumber(), consumerInfoBean.getRegion())) {
				modelMap.addAttribute("msg", "request sent.");
			}else {
				modelMap.addAttribute("msg", "failed to send a request.");
			}
			return "consumerHomePage";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}
	
	@GetMapping("/displayCurrentBillPage")
	public String displayCurrentBillPage(HttpSession session, ModelMap modelMap) {
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInCons");
		if (consumerInfoBean != null) {
			CurrentBill currentBill = service.getCurrentBill(consumerInfoBean.getRrNumber());
			if (currentBill != null) {
				modelMap.addAttribute("currentBill", currentBill);
				return "currentBillPage";
			} else {
				modelMap.addAttribute("errMsg", "No Current Bill is Found.!!");
				return "consumerFailedPage";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}

	@GetMapping("/displyPasswordPage")
	public String displayPasswordForgotPage(HttpSession session, ModelMap modelMap) {
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInCons");
		if (consumerInfoBean != null) {
			return "passwordChange";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}

	@PostMapping("/changePassword")
	public String changePassword(HttpSession session, ModelMap modelMap, String password, String confPassword) {
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInCons");
		if (consumerInfoBean != null) {
			if (service.changePassword(password, confPassword, consumerInfoBean.getRrNumber())) {
				modelMap.addAttribute("msg", "Password Changed Successfully");
			} else {
				modelMap.addAttribute("errMsg", "Failed to change the password!!");
			}
			return "passwordChange";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}


	@GetMapping("/diplayResponse")
	public String getResponse(HttpSession session, ModelMap modelMap) {
		ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInCons");
		if (consumerInfoBean != null) {
			List<SupportBean> supportBean = service.getResponse(consumerInfoBean.getRrNumber());
			modelMap.addAttribute("supportBean", supportBean);
			return "consumerResponsePage";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}

}
