package com.bcits.jpawithhibernate.maping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;
import com.bcits.jpawithhibernateapp.bean.EmployeeSecondaryInfo;

public class OneToOne {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;

		EmployeePrimaryInfo primary_info = new EmployeePrimaryInfo();
		EmployeeSecondaryInfo secondary_employee = new EmployeeSecondaryInfo();

		primary_info.setEmpid(200);
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
//		 secondary_employee.setPrimary(primary_info);
		primary_info.setSecond_info(secondary_employee);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
//				manager.persist(secondary_employee);
			EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, 100);
			System.out.println(info.getEmpname());
			System.out.println(info.getSecond_info().getGurdian_name());
			System.out.println(info.getSecond_info().getGurdian_contactno());
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}

}
