package com.bcits.usecasemodule.validation;

public class EmployeeValidationForm {

	// employee name validation

	public  boolean nameValidation(String name) {

		if (name == null && name.isEmpty()) {
			return true;
		} else if ((name.length() < 3) || (name.length() > 20)) {
			return true;
		} else if (!name.matches("^[A-Za-z\\s]+")) {
			return true;
		} else {
			return false;
		}
	}

	// designation validation
	public  boolean designationValidation(String designation) {

		if (designation == null && designation.isEmpty()) {
			return true;
		} else if (!designation.matches("^[A-Za-z\\s]+")) {
			return true;
		} else {
			return false;
		}

	}

	// employee validation
	public  boolean empIdValidation(int empId) {

		String id = empId + "";
		if (empId == 0) {
			return true;
		} else if (id.length() < 4 || id.length() > 7) {
			return true;
		} else {
			return false;
		}
	}

	// region validation
	public  boolean regionValidation(String region) {
		if (region == null && region.isEmpty()) {
			return true;
		} else if (!region.matches("^[A-Za-z\\s]+")) {
			return true;
		} else {
			return false;
		}

	}

	// Password validation
	public  boolean passwordValidation(String password) {

		if (password == null && password.isEmpty()) {
			return true;
		} else if (password.length() < 4 || password.length() > 15) {
			return true;
		} else {
			return false;
		}
	}

}
