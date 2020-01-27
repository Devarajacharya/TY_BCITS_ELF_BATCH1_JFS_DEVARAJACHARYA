package com.bcits.jpawithhibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.onetoone.EmployeeSecondaryInfo;
import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class OneToOneInsert {
	
public static void main(String[] args) {
	
		EntityManager manager = null;
		EntityTransaction transaction = null;
		
		EmployeePrimaryInfo primary_info = new EmployeePrimaryInfo();
		EmployeeSecondaryInfo secondary_employee = new EmployeeSecondaryInfo();

		
		primary_info.setEmpid(240);
		primary_info.setEmpname("prajwal");
		primary_info.setMobile_no(9008009361l);
		primary_info.setDOB(java.sql.Date.valueOf("1995-07-02"));
		primary_info.setDOJ(java.sql.Date.valueOf("2017-11-11"));
		primary_info.setDesignation("Graphic Designer");
		primary_info.setBlood_group("O+");
		primary_info.setDeptid(10);
		primary_info.setManager_id(40);
		primary_info.setSal(22500.54);
		primary_info.setOfficial_mail("prajwal578@gmail.com");
		
		 secondary_employee.setPersonalMail("pj237347@gmail.com");
		 secondary_employee.setGender("male");
		 secondary_employee.setAge(29);
		 secondary_employee.setNationality("Indian");
		 secondary_employee.setJob_loc("Jaipur");
		 secondary_employee.setIs_married("Yes");
		 secondary_employee.setGovt_id("4657-5748-4857");
		 secondary_employee.setGurdian_name("Ganesh");
		 secondary_employee.setGurdian_contactno(7384593190l);
		 primary_info.setSecondary_info(secondary_employee);

		

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
//			manager.persist(primary_info);
			EmployeeSecondaryInfo info = manager.find(EmployeeSecondaryInfo.class, 100);
			System.out.println(info.getPrimary().getEmpname());
			System.out.println(info.getGurdian_contactno());
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

