package com.bcits.springrestjaxb.jsontest;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserJSONUnMarshalling {

	public static void main(String[] args) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UserInfoBean userInfoBean = objectMapper.readValue(new File("userJSON2.json"), UserInfoBean.class);
			
			System.out.println("User Id       : "+userInfoBean.getEmpid());
			System.out.println("User Name     : "+userInfoBean.getEmpname());
			System.out.println("Salary        : "+userInfoBean.getSal());
			System.out.println("DOB           : "+userInfoBean.getDOB());
			System.out.println("Designation   : "+userInfoBean.getDesignation());
			System.out.println("Mobile Number : "+userInfoBean.getMobileNo());
			System.out.println("Email Id      : "+userInfoBean.getOfficialMail());
			System.out.println("BloodGroup    : "+userInfoBean.getBloodGroup());
			System.out.println("Gender        : "+userInfoBean.getUseOtherInfobean().getGender());
			System.out.println("Aadhar Number : "+userInfoBean.getUseOtherInfobean().getAadharNumber());
			System.out.println("Hose Number   : "+userInfoBean.getUserAddressBean().get(0).getHouseNum());
			System.out.println("City          : "+userInfoBean.getUserAddressBean().get(0).getCity());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
