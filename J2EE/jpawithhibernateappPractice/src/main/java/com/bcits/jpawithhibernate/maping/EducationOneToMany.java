package com.bcits.jpawithhibernate.maping;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bcits.jpawithhibernate.onetomany.EmployeeEducationPK;

public class EducationOneToMany {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		
		EmployeeEducationPK educationPK1 = new EmployeeEducationPK();
		EmployeeEducationPK educationPK2 = new EmployeeEducationPK();
		EmployeeEducationPK educationPK3 = new EmployeeEducationPK();

		
		educationPK1.setEmpid(300);
		educationPK1.setEducation_type("SSLC");
		
		educationPK2.setEmpid(300);
		educationPK2.setEducation_type("PUC");
		
		educationPK2.setEmpid(300);
		educationPK2.setEducation_type("BTECH");

	}
}
