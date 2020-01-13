package com.bcits.jpawithhibernate.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.manytomany.ProjectInfo;
import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class ManyToMany {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;

		EmployeePrimaryInfo primary_info1 = new EmployeePrimaryInfo();
		primary_info1.setEmpid(280);
		primary_info1.setEmpname("praveen");
		primary_info1.setMobile_no(9087009361l);
		primary_info1.setDOB(java.sql.Date.valueOf("1995-03-22"));
		primary_info1.setDOJ(java.sql.Date.valueOf("2018-05-21"));
		primary_info1.setDesignation("Software");
		primary_info1.setBlood_group("AB+");
		primary_info1.setDeptid(30);
		primary_info1.setManager_id(10);
		primary_info1.setSal(33300.54);
		primary_info1.setOfficial_mail("praveen@gmail.com");


		EmployeePrimaryInfo primary_info2 = new EmployeePrimaryInfo();
		primary_info2.setEmpid(290);
		primary_info2.setEmpname("ganesh");
		primary_info2.setMobile_no(8678909361l);
		primary_info2.setDOB(java.sql.Date.valueOf("1981-03-22"));
		primary_info2.setDOJ(java.sql.Date.valueOf("2001-01-21"));
		primary_info2.setDesignation("Finance");
		primary_info2.setBlood_group("B+");
		primary_info2.setDeptid(30);
		primary_info2.setManager_id(10);
		primary_info2.setSal(76300.54);
		primary_info2.setOfficial_mail("ganesh@gmail.com");

		ArrayList<EmployeePrimaryInfo> info = new ArrayList<EmployeePrimaryInfo>();
		info.add(primary_info1);
		info.add(primary_info2);

		ProjectInfo p1 = new ProjectInfo();
		p1.setPrjid(60);
		p1.setPrjname("e-commerce");
		p1.setLocation("UDUPI");
		p1.setStart_date(java.sql.Date.valueOf("2019-03-22"));
		p1.setEnd_date(java.sql.Date.valueOf("2020-01-10"));
		p1.setTechnology("java");
		p1.setPrimary(info);
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(p1);
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

