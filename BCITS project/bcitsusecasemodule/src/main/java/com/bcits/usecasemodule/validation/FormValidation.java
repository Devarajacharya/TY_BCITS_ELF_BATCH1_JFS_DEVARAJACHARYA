package com.bcits.usecasemodule.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValidation {

	// RR NUmber Validation
	public boolean rrValidation(String rrNumber) {
		Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~a-z]");
		Matcher hasSpeical = special.matcher(rrNumber);

		if (rrNumber == null || rrNumber.isEmpty()) {
			return true;
		} else if (hasSpeical.find()) {
			return true;
		} else if ((rrNumber.length() < 6) || (rrNumber.length() > 9)) {
			return true;
		}
		return false;

	}

	// Email Id validation
	public boolean emailValidation(String email) {

		String emailPattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

		if (email == null && email.isEmpty()) {
			return true;
		} else if (!email.matches(emailPattern)) {
			return true;
		} else {
			return false;
		}
	}

	// Region Validation
	public boolean regionValidation(String region) {

		if (region == null && region.isEmpty()) {
			return true;
		} else if (!region.matches("^[A-Za-z\\s]+")) {
			return true;
		} else {
			return false;
		}
	}

	// Amount validation
	public boolean amountValidation(double amount) {

		String amt = amount + "";

		if (amount < 0) {
			return true;
		} else if (amt.matches("((/d{1,4})(((//.)(/d{0,2})){0,1}))")) {
			return true;
		}
		return false;
	}

	// Request Message Validation
	public boolean requetValidation(String query) {

		if (query == null && query.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	//employee id validation
	public boolean empIdValidation(int empId) {

		String id = empId + "";

		if (empId == 0) {
			return true;
		} else if (id.length() < 4 || id.length() > 7) {
			return true;
		} else {
			return false;
		}
	}

	// Response Message Validation
	public boolean responseValidation(String response) {

		if (response == null && response.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	//Password validation
	public boolean passwordValidation(String password) {
		
		if(password == null && password.isEmpty()) {
			return true;
		}else if(password.length() < 5 && password.length() > 15){
			return true;
		} else {
			return false;
		}
	}
}
