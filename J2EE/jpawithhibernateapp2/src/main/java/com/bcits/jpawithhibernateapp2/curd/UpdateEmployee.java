package com.bcits.jpawithhibernateapp2.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class UpdateEmployee {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, 100);
			info.setSal(50000.00);
			transaction.commit();
			System.out.println("Record Updated..");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			manager.close();
		}
	}

}
