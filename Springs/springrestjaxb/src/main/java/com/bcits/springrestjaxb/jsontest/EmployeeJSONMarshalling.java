package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeBean;

public class EmployeeJSONMarshalling {
	public static void main(String[] args) {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmpid(100);
		employeeBean.setEmpname("sonu A");
		employeeBean.setDesignation("HR");
		employeeBean.setBloodGroup("O+");
		employeeBean.setDeptId(10);
		employeeBean.setDOB(new Date());
		employeeBean.setDOJ(new Date());
		employeeBean.setMobileNo(9008768223l);
		employeeBean.setOfficialMail("amisha123@Gmail.com");
		employeeBean.setSal(25000.87);
		employeeBean.setPassword("qwerty");
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter();
			mapper.writeValue(new File("empJSON4.json"), employeeBean);
			mapper.writeValue(System.out, employeeBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
