package com.bcits.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bcits.springmvccustomexception.EmployeeException;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeException.class)
	public String employeeExceptionHandler(EmployeeException empException , HttpServletRequest req) {
		String errMsg = empException.getMessage();
		req.setAttribute("errMsg", errMsg);
		return "errorPage";
	}
}
