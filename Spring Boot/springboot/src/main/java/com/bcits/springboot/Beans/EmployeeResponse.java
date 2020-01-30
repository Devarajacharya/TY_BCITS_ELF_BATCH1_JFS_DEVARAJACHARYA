package com.bcits.springboot.Beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"statusCode","message","description"})
public class EmployeeResponse {
	private int statusCode;
	private String message;
	private String description;
	private EmployeeInfoBean employeeInfoBean;
	private List<EmployeeInfoBean> empList;

}
