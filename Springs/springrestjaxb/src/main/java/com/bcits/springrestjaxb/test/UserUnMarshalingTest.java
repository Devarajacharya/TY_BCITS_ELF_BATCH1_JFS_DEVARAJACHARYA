package com.bcits.springrestjaxb.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserUnMarshalingTest {
	public static void main(String[] args) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(UserInfoBean.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			UserInfoBean userInfoBean = (UserInfoBean)unmarshaller.unmarshal(new File("userInfo.xml"));
			System.out.println("User Id        : "+userInfoBean.getEmpid());
			System.out.println("User Name      : "+userInfoBean.getEmpname());
			System.out.println("Salary        : "+userInfoBean.getSal());
			System.out.println("DOB           : "+userInfoBean.getDOB());
			System.out.println("Designation   : "+userInfoBean.getDesignation());
			System.out.println("Mobile Number : "+userInfoBean.getMobileNo());
			System.out.println("Email Id      : "+userInfoBean.getOfficialMail());
			System.out.println("BloodGroup    : "+userInfoBean.getBloodGroup());
			System.out.println("Gender        : "+userInfoBean.getUseOtherInfobean().getGender());
			System.out.println("Aadhar Number : "+userInfoBean.getUseOtherInfobean().getAadharNumber());
//			System.out.println("House Number  : "+userInfoBean.getUserAddressBean());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

}
