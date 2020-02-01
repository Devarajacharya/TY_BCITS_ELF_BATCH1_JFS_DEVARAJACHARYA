package com.bcits.usecasemodule.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValidation {

	public static boolean rrValidation(String rrNumber) {
		Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~a-z]");
		Matcher hasSpeical = special.matcher(rrNumber);

		if (rrNumber == null || rrNumber.isEmpty()) {
			return true;

		} else if (hasSpeical.find()) {
			return true;
		}
		return false;

	}
}
