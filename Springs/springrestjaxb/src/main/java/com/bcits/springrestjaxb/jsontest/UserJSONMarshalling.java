package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtherInfobean;

public class UserJSONMarshalling {
	public static void main(String[] args) {
		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setEmpid(100);
		userInfoBean.setEmpname("Amisha A");
		userInfoBean.setDesignation("HR");
		userInfoBean.setBloodGroup("O+");
		userInfoBean.setDeptId(10);
		userInfoBean.setDOB(new Date());
		userInfoBean.setDOJ(new Date());
		userInfoBean.setMobileNo(9008768223l);
		userInfoBean.setOfficialMail("amisha123@Gmail.com");
		userInfoBean.setSal(25000.87);
		userInfoBean.setPassword("qwerty");
		UserOtherInfobean userOtherInfobean = new UserOtherInfobean();

		userOtherInfobean.setGender("female");
		userOtherInfobean.setAadharNumber(3342328373l);
		userInfoBean.setUseOtherInfobean(userOtherInfobean);
		
		List<UserAddressBean> userAddressList = new ArrayList<UserAddressBean>();
		UserAddressBean perAdressInfo = new UserAddressBean();
		perAdressInfo.setHouseNum(23);
		perAdressInfo.setCity("manglore");
		perAdressInfo.setStreet("abc street");
		perAdressInfo.setAddressType("permanent");

		UserAddressBean tempAdressInfo = new UserAddressBean();
		tempAdressInfo.setHouseNum(23);
		tempAdressInfo.setCity("manglore");
		tempAdressInfo.setStreet("abc street");
		tempAdressInfo.setAddressType("permanent");
		userAddressList.add(tempAdressInfo);
		userAddressList.add(perAdressInfo);
		
		userInfoBean.setUserAddressBean(userAddressList);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("userJSON2.json"), userInfoBean);
			mapper.writeValue(System.out, userInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
