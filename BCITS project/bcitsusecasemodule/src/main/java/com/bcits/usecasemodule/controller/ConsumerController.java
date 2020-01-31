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

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
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
	public String addConsumerDetails(ConsumerInfoBean conInfoBean ,ModelMap modelMap ,String cnfPassword) {
		if(service.addConsumer(conInfoBean , cnfPassword)) {
			modelMap.addAttribute("msg", "You have signed up sucessfully");
			return "consumerLoginPage";
	}else {
		modelMap.addAttribute("errMsg", "Sign Up failed");
		return "consumerSignUpPage";
		}
	}
	
	@PostMapping("/consumerLogin") 
	public String ConsumerLogin(String rrNumber, String password ,HttpServletRequest req ,ModelMap modelMap) {
		ConsumerInfoBean consumerInfoBean = service.authentication(rrNumber, password);
		if( consumerInfoBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInCons", consumerInfoBean);
			return "consumerHomePage";
		}else {
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
	public String dispalyPaymentPage(HttpSession session ,ModelMap modelMap) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg","Please Login First");
			return "consumerLoginPage";
		}else {
			return "paymentPage";
		}
	}
	
	@PostMapping("/successfullPaymentPage")
	public String displaySucessfullPaymentPage(HttpSession session,ModelMap modelMap) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg","Please Login First");
			return "consumerLoginPage";
		}else {
			return "paymentSuccessfullPage";
		}
	}
	
	@GetMapping("/displayConsumerHome")
	public String displayConsumerHomePage(HttpSession session, ModelMap modelMap) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg","Please Login First");
			return "consumerLoginPage";
		}else {
			return "consumerHomePage";
		}
	}
	
	@GetMapping("/displayMonthlyConsumptionPage")
	public String displayMonthlyConsumptionPage(HttpSession session, ModelMap modelMap) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg","Please Login First");
			return "consumerLoginPage";
		}else {
			return "monthlyConsumptionPage";
		}
	}
	
	@GetMapping("/displayBillHistorysPage")
	public String displayBillHistoryPage(HttpSession session, ModelMap modelMap) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg","Please Login First");
			return "consumerLoginPage";
		}else {
			return "billHistoryPage";
		}
	}
	
	@GetMapping("/displayCurrentBillPage")
	public String displayCurrentBillPage(HttpSession session, ModelMap modelMap) {
		ConsumerInfoBean consumerInfoBean =(ConsumerInfoBean)session.getAttribute("loggedInCons");
		if (consumerInfoBean != null) {
			CurrentBill currentBill = service.getCurrentBill(consumerInfoBean.getRrNumber());
			if(currentBill != null) {
				modelMap.addAttribute("currentBill",currentBill);
				return "currentBillPage";
			}else {
				modelMap.addAttribute("Unable to Proccess try Later.!!","errMsg");
				return "consumerFailedPage";
			}
			
		}else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}
	
}


















