package com.bcits.jpawithhibernate.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.manytomany.ProjectInfo;
import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class ManytoManyBidirection {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		
		ArrayList<ProjectInfo> prj_info =new ArrayList<ProjectInfo>();
		
		
		
		ProjectInfo prj1 = new ProjectInfo();
		prj1.setPrjid(70);
		prj1.setPrjname("e-commerce");
		prj1.setLocation("UDUPI");
		prj1.setStart_date(java.sql.Date.valueOf("2019-03-22"));
		prj1.setEnd_date(java.sql.Date.valueOf("2020-01-10"));
		prj1.setTechnology("java");
		
		ProjectInfo prj2 = new ProjectInfo();
		prj2.setPrjid(80);
		prj2.setPrjname("mr");
		prj2.setLocation("Manglore");
		prj2.setStart_date(java.sql.Date.valueOf("2019-03-22"));
		prj2.setEnd_date(java.sql.Date.valueOf("2020-01-10"));
		prj2.setTechnology("SQL");
		
		prj_info.add(prj1);
		prj_info.add(prj2);

		EmployeePrimaryInfo primary_info1 = new EmployeePrimaryInfo();
		primary_info1.setEmpid(290);
		primary_info1.setEmpname("prajna");
		primary_info1.setMobile_no(9089869361l);
		primary_info1.setDOB(java.sql.Date.valueOf("1991-03-22"));
		primary_info1.setDOJ(java.sql.Date.valueOf("2011-05-21"));
		primary_info1.setDesignation("Tester");
		primary_info1.setBlood_group("AB+");
		primary_info1.setDeptid(30);
		primary_info1.setManager_id(10);
		primary_info1.setSal(13300.54);
		primary_info1.setOfficial_mail("prajna@gmail.com");
		primary_info1.setProject(prj_info);


		EmployeePrimaryInfo primary_info2 = new EmployeePrimaryInfo();
		primary_info2.setEmpid(3000);
		primary_info2.setEmpname("deepa");
		primary_info2.setMobile_no(8678909361l);
		primary_info2.setDOB(java.sql.Date.valueOf("1989-03-22"));
		primary_info2.setDOJ(java.sql.Date.valueOf("2005-01-21"));
		primary_info2.setDesignation("HR");
		primary_info2.setBlood_group("B-");
		primary_info2.setDeptid(20);
		primary_info2.setManager_id(50);
		primary_info2.setSal(78800.54);
		primary_info2.setOfficial_mail("deepa@gmail.com");
		primary_info1.setProject(prj_info);


		ArrayList<EmployeePrimaryInfo> emp_info = new ArrayList<EmployeePrimaryInfo>();
		emp_info.add(primary_info1);
		emp_info.add(primary_info2);
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(emp_info);
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


