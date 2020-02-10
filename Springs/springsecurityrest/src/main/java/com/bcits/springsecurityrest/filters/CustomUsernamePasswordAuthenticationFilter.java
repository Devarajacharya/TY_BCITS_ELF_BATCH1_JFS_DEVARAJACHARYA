package com.bcits.springsecurityrest.filters;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bcits.springsecurityrest.beans.EmployeeInfoBean;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomUsernamePasswordAuthenticationFilter  extends UsernamePasswordAuthenticationFilter{

	private EmployeeInfoBean empBean;
	
	@Override
	protected String obtainUsername(HttpServletRequest request) {
		
		if(request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
			try {
				EmployeeInfoBean emInfoBean = getEmpInfo(request);
				return emInfoBean.getEmpId()+"";
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		return super.obtainUsername(request);
	}
	
	@Override
	protected String obtainPassword(HttpServletRequest request) {
		
		if(request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
			try {
				EmployeeInfoBean emInfoBean = getEmpInfo(request);
				return emInfoBean.getPassword();
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		return super.obtainPassword(request);
	}
	
	private EmployeeInfoBean getEmpInfo(HttpServletRequest request) throws IOException {
		if(empBean == null) {
			ObjectMapper objectMapper = new ObjectMapper();
			String json ="";
			
			BufferedReader reader = request.getReader();
			while(reader.ready()) {
				json = json + request.getReader();			
				}
			empBean = objectMapper.readValue(json, EmployeeInfoBean.class);
		}
		return empBean;
		
	}
}
