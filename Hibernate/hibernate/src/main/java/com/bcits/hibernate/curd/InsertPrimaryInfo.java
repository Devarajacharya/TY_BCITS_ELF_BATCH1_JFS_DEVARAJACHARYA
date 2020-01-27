package com.bcits.hibernate.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;

import com.bcits.hibernate.bean.EmployeePrimaryInfo;

public class InsertPrimaryInfo {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction trns = null;
		
		EmployeePrimaryInfo primary_info = new EmployeePrimaryInfo();
		primary_info.setEmpid(150);
		primary_info.setEmpname("prajwal");
		primary_info.setMobile_no(9008009361l);
		primary_info.setDOB(java.sql.Date.valueOf("1995-07-02"));
		primary_info.setDOJ(java.sql.Date.valueOf("2017-11-11"));
		primary_info.setDesignation("Graphic Designer");
		primary_info.setBlood_group("O+");
		primary_info.setDeptid(10);
		primary_info.setManager_id(4);
		primary_info.setSal(22500.54);
		primary_info.setOfficial_mail("prajwal578@gmail.com");

		try {
			factory = Persistence.createEntityManagerFactory("Test");
			manager = factory.createEntityManager();
			trns = manager.getTransaction();
			trns.begin();
			manager.persist(primary_info);
			trns.commit();
			System.out.println("Recor updated...");
		} catch (Exception e) {
			e.printStackTrace();
			trns.rollback();
		}finally {
			manager.close();
		}

	}
}
