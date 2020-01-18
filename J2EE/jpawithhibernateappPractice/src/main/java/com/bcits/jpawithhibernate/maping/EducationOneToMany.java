package com.bcits.jpawithhibernate.maping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.onetomany.EmployeeEducationPK;
import com.bcits.jpawithhibernateapp.bean.EmployeeEducationInfo;
import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

public class EducationOneToMany {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		
		EmployeeEducationPK educationPK1 = new EmployeeEducationPK();
		EmployeeEducationPK educationPK2 = new EmployeeEducationPK();
		EmployeeEducationPK educationPK3 = new EmployeeEducationPK();
		List<EmployeeEducationInfo> edu = new ArrayList<EmployeeEducationInfo>();
		
		educationPK1.setEmpid(330);
		educationPK1.setEducation_type("SSLC");
		
		educationPK2.setEmpid(330);
		educationPK2.setEducation_type("PUC");
		
		educationPK3.setEmpid(330);
		educationPK3.setEducation_type("BTECH");
		
		EmployeePrimaryInfo primary_info = new EmployeePrimaryInfo();
		primary_info.setEmpid(330);
		primary_info.setEmpname("rajgopal");
		primary_info.setMobile_no(90052009361l);
		primary_info.setDOB(java.sql.Date.valueOf("1993-03-29"));
		primary_info.setDOJ(java.sql.Date.valueOf("2018-01-01"));
		primary_info.setDesignation("Manager");
		primary_info.setBlood_group("A+");
		primary_info.setDeptid(20);
		primary_info.setManager_id(10);
		primary_info.setSal(77300.54);
		primary_info.setOfficial_mail("rajgopal578@gmail.com");
		
		EmployeeEducationInfo eduInfo1= new EmployeeEducationInfo();
		EmployeeEducationInfo eduInfo2=new EmployeeEducationInfo();
		EmployeeEducationInfo eduInfo3=new EmployeeEducationInfo();
		
		eduInfo1.setEduPK(educationPK1);
		eduInfo1.setCollege_name("SRS");
		eduInfo1.setYOP(java.sql.Date.valueOf("2011-07-29"));
		eduInfo1.setStream("CBSC");
		eduInfo1.setPercentage(78.5);
		eduInfo1.setUniversity("MANGLORE");
		eduInfo1.setPrimaryInfos(primary_info);
		
		eduInfo2.setEduPK(educationPK2);
		eduInfo2.setCollege_name("PUC hiriadka");
		eduInfo2.setYOP(java.sql.Date.valueOf("2013-06-29"));
		eduInfo2.setStream("SC");
		eduInfo2.setPercentage(78.04);
		eduInfo2.setUniversity("Banglore");
		eduInfo2.setPrimaryInfos(primary_info);
		
		eduInfo3.setEduPK(educationPK3);
		eduInfo3.setCollege_name("MIT");
		eduInfo3.setYOP(java.sql.Date.valueOf("2016-07-05"));
		eduInfo3.setStream("ECE");
		eduInfo3.setPercentage(69.04);
		eduInfo3.setUniversity("Manipal University");
		eduInfo3.setPrimaryInfos(primary_info);
		
		edu.add(eduInfo1);
		edu.add(eduInfo2);
		edu.add(eduInfo3);
		primary_info.setEducationInfo(edu);
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(primary_info);
			System.out.println("Record Saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}
}

