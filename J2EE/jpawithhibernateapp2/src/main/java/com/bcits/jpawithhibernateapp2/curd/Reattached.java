package com.bcits.jpawithhibernateapp2.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class Reattached {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityManagerFactory entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = Persistence.createEntityManagerFactory("Test");
			manager = entityManager.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, 100);
			System.out.println(manager.contains(info));
			manager.detach(info);
			System.out.println(manager.contains(info));
			EmployeePrimaryInfo reattached = manager.merge(info);
			reattached.setDesignation("Software Developer");
			transaction.commit();
			System.out.println("Record Is Updated..");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}
}
