package com.bcits.discom.trarifflogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static boolean rrValidation(String str) {
		Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~a-z]");
		Matcher hasSpeical =special.matcher(str);
		if(str == null || str.isEmpty())	{
		return true;

	}else if(hasSpeical.find()){
		return true;
	}
		return false;
	
	}
	
	public static boolean nameValidation(String str) {
		if(str == null ||  str.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}
