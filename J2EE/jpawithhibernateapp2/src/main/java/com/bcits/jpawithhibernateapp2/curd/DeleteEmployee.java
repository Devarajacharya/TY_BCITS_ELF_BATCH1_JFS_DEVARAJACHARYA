package com.bcits.jpawithhibernateapp2.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class DeleteEmployee {

	public static void main(String[] args) {
		EntityManagerFactory entityManager = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = Persistence.createEntityManagerFactory("Test");
			manager = entityManager.createEntityManager();
			transaction = manager.getTransaction();
			EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, 210);
			transaction.begin();
			manager.remove(info);
			transaction.commit();
			System.out.println("record is Deleted..");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
	}
}
