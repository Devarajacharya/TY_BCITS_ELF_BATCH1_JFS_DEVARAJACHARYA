package com.bcits.jpawithhibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.onetoone.EmployeeBankInfo;
import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class OneToOneInsert2 {
	
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		
		EmployeePrimaryInfo primary_info = new EmployeePrimaryInfo();
		primary_info.setEmpid(260);
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
		
		EmployeeBankInfo bank_info = new EmployeeBankInfo();
		bank_info.setAccount_no(9876543245l);
		bank_info.setBank_name("Vijay");
		bank_info.setBranch_name("Perdoor");
		bank_info.setIFSC_code("VIJF637484");
		primary_info.setBank_info(bank_info);
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

