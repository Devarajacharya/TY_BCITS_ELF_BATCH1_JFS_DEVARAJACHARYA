package com.bcits.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bcits.springmvc.bean.UserBean;

@Controller
public class SpringMVCController {

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public ModelAndView getHelloMessage() {
		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("/WEB-INF/views/messagePage.jsp");
		modelAndView.setViewName("messagePage");
		return modelAndView;
	}

	@RequestMapping(path = "/searchEmployee", method = RequestMethod.GET)
	public ModelAndView searchEmployee(HttpServletRequest req) {
		String empId = req.getParameter("empId");
		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("/WEB-INF/views/searchEmployee.jsp");
		modelAndView.setViewName("searchEmployee");
		req.setAttribute("empId", empId);
		return modelAndView;
	}

	@RequestMapping(path = "/loginForm", method = RequestMethod.GET)
	public ModelAndView displayLoginForm(ModelAndView modelAndView) {
//		modelAndView.setViewName("/WEB-INF/views/loginForm.jsp");
		modelAndView.setViewName("loginForm");
		return modelAndView;
	}

	@RequestMapping(path = "/login1", method = RequestMethod.POST)
	public ModelAndView login1(HttpServletRequest req, ModelAndView modelAndView) {
		int empId = Integer.parseInt(req.getParameter("empId"));
		String password = req.getParameter("password");

		modelAndView.addObject("empId", empId);
		modelAndView.addObject("psw", password);
//		modelAndView.setViewName("/WEB-INF/views/userDetail.jsp");
		modelAndView.setViewName("userDetail");
		return modelAndView;
	}

	@PostMapping("/login2")
	public ModelAndView login2(@RequestParam(name = "empId") int empId,
			@RequestParam(name = "password") String password, ModelAndView modelAndView) {
		modelAndView.addObject("empId", empId);
		modelAndView.addObject("psw", password);
//		modelAndView.setViewName("/WEB-INF/views/userDetail.jsp");
		modelAndView.setViewName("userDetail");
		return modelAndView;
	}

	@PostMapping("/login3")
	public String login3(int empId, String password, ModelMap modelMap) {
		modelMap.addAttribute("empId", empId);
		modelMap.addAttribute("psw", password);
//		return "/WEB-INF/views/userDetail.jsp";
		return "userDetail";
	}

	@PostMapping("/login4")
	public String Login4(UserBean userBean, String name, ModelMap modelMap) {
		modelMap.addAttribute("userBean", userBean);
		modelMap.addAttribute("name", name);
//		return "/WEB-INF/views/userDetail2.jsp";
		return "userDetail2";

	}
}
