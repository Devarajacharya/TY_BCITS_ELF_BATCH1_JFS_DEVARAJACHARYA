package com.bcits.hibernate.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.hibernate.bean.EmployeePrimaryInfo;

public class DeleteEmployee {

	public static void main(String[] args) {
		EntityManagerFactory entityManager = null;
		EntityManager manager = null;
		EntityTransaction trns = null;
		try {
			entityManager = Persistence.createEntityManagerFactory("Test");
			manager = entityManager.createEntityManager();
			EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, 10);
			EntityTransaction trans = manager.getTransaction();
			trans.begin();
			manager.remove(info);
			trans.commit();
			System.out.println("record Deleted....s");

		} catch (Exception e) {
			e.printStackTrace();
			trns.rollback();
		} finally {
			manager.close();
		}
	}
}
