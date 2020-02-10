package com.bcits.springsecurityrest.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
	private int statusCode;
	private String message;
	private String description;
	
	private EmployeeInfoBean empBean;
	private List<EmployeeInfoBean> empList;
	
}//End of Class
