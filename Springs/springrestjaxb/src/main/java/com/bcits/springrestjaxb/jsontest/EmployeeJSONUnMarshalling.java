package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import com.bcits.springrestjaxb.beans.EmployeeBean;

public class EmployeeJSONUnMarshalling {
	public static void main(String[] args) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			EmployeeBean employeeBean = objectMapper.readValue(new File("empJSON3.json"), EmployeeBean.class);
			
			System.out.println("Emp Id        : "+employeeBean.getEmpid());
			System.out.println("Emp Name      : "+employeeBean.getEmpname());
			System.out.println("Salary        : "+employeeBean.getSal());
			System.out.println("DOB           : "+employeeBean.getDOB());
			System.out.println("Designation   : "+employeeBean.getDesignation());
			System.out.println("Mobile Number : "+employeeBean.getMobileNo());
			System.out.println("Email Id      : "+employeeBean.getOfficialMail());
			System.out.println("BloodGroup    : "+employeeBean.getBloodGroup());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
