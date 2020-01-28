package com.bcits.springrestjaxb.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.EmployeeBean;

public class EmployeeUnMarshallingTest {
	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeBean.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			EmployeeBean employeeBean = (EmployeeBean) unmarshaller.unmarshal(new File("employeeInfo2.xml"));
			
			System.out.println("Emp Id        : "+employeeBean.getEmpid());
			System.out.println("Emp Name      : "+employeeBean.getEmpname());
			System.out.println("Salary        : "+employeeBean.getSal());
			System.out.println("DOB           : "+employeeBean.getDOB());
			System.out.println("Designation   : "+employeeBean.getDesignation());
			System.out.println("Mobile Number : "+employeeBean.getMobileNo());
			System.out.println("Email Id      : "+employeeBean.getOfficialMail());
			System.out.println("BloodGroup    : "+employeeBean.getBloodGroup());
			
		} catch (JAXBException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		
	}

}
