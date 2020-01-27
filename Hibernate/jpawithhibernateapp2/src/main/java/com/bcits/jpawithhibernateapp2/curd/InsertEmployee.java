package com.bcits.jpawithhibernateapp2.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class InsertEmployee {
	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		EmployeePrimaryInfo primary_info = new EmployeePrimaryInfo();
		primary_info.setEmpid(230);
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
