package com.bcits.springrestjaxb.test;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeBean;

public class EmployeeMarshallingTest {

	public static void main(String[] args) {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmpid(100);
		employeeBean.setEmpname("Amisha A");
		employeeBean.setDesignation("HR");
		employeeBean.setBloodGroup("O+");
		employeeBean.setDeptId(10);
		employeeBean.setDOB(new Date());
		employeeBean.setDOJ(new Date());
		employeeBean.setMobileNo(9008768223l);
		employeeBean.setOfficialMail("amisha123@Gmail.com");
		employeeBean.setSal(25000.87);
		employeeBean.setPassword("qwerty");
		
		//marshelling into JSON
		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeBean.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // For fORMAT XML
			marshaller.marshal(employeeBean, System.out);
			marshaller.marshal(employeeBean, new File("employeeInfo.xml"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("\n\nUnable to Marshal!!");
		}
		
	}
}
