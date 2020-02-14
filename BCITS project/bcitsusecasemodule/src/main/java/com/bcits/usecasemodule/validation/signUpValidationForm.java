package com.bcits.usecasemodule.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;

public class signUpValidationForm {

	public static boolean signUpValidation(ConsumerInfoBean consumerInfoBean) {
		String fname = consumerInfoBean.getFirstName();
		String lname = consumerInfoBean.getLastName();
		String email = consumerInfoBean.getEmail();
		long phnone = consumerInfoBean.getPhoneNumber();
		String psw = consumerInfoBean.getPassword();
		String rrNumber = consumerInfoBean.getRrNumber();
		String region = consumerInfoBean.getRegion();
		String consumerType = consumerInfoBean.getTypeOfConsumer();
		String hNumber = consumerInfoBean.getHouseNumber();
		String address1 = consumerInfoBean.getAddress1();
		String address2 = consumerInfoBean.getAddress2();

		Pattern namePattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?0-9]");
		Pattern rrNumberPattern = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~a-z]");
		Pattern emailPattern= Pattern.compile("[!#$%^*()+\\=\\[\\]{};':\"\\\\|,<>\\/?A-Z]");
		Pattern mobilePattern = Pattern.compile("[7-9][0-9]{9}");
		Pattern regionPattern = Pattern.compile("^[a-zA-Z]*$");


		Matcher hasFname = namePattern.matcher(fname);
		Matcher hasLname = namePattern.matcher(lname);
		Matcher hasEmail = emailPattern.matcher(email);
		Matcher hasMobile = mobilePattern.matcher(phnone+"");
		Matcher hasRRNumber = rrNumberPattern.matcher(rrNumber);
		Matcher hasRegion = regionPattern.matcher(region);

		// First Name Validation
		if (fname == null && fname.isEmpty()) {
			return true;
		} else if ((fname.length() < 3) || (fname.length() > 20)) {
			return true;
		} else if (hasFname.find()) {
			return true;
		}
		
		// Last Name Validation
		if (lname == null && lname.isEmpty()) {
			return true;
		} else if (hasLname.find()) {
			return true;
		}

		// Email validation
		if (email == null && email.isEmpty()) {
			return true;
		}else if(email.length() < 12 ){
			return true;
		}else if(hasEmail.find()) {
			return true;
		}
		
		// Phone Number Validation
		if(phnone == 0) {
			return true;
		} else if (phnone+"".length() < 10) {
			return true;
		}else if(!hasMobile.find()){
			return true;
		}
		
		// Password validation
		if(psw == null && psw.isEmpty()) {
			return true;
		}else if (psw.length() < 5) {
			return true;
		}
		
		//RR Number validation
		if (rrNumber == null || rrNumber.isEmpty()) {
			return true;
		} else if (hasRRNumber.find()) {
			return true;
		}else if((rrNumber.length() < 6) || (rrNumber.length() > 9)) {
			return true;
		}
		
		//Region validation
		if(region == null && region.isEmpty()) {
			return true;
		}else if(hasRegion.find()) {
			return true;
		}
		
		//type of consumer validation
		if(consumerType == null && consumerType.isEmpty()) {
			return true;
		}
		
		//House Number
		if(hNumber == null  && hNumber.isEmpty()) {
			return true;
		}
		
		//Address1 validation
		if(address1 == null && address1.isEmpty()) {
			return true;
		}
		
		//Address2 validation
		if(address2 == null && address2.isEmpty()) {
			return true;
		}
		
		
		return false;

	}
	
}
