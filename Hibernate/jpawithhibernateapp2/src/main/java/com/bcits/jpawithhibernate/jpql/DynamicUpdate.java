package com.bcits.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicUpdate {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
		factory = Persistence.createEntityManagerFactory("Test");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		String jpql = " update from EmployeePrimaryInfo set empname = :ename where empid = :id ";
		Query query = manager.createQuery(jpql);
		query.setParameter("id", 215);
		query.setParameter("ename", "PJ");
		int res = query.executeUpdate();
		System.out.println("Number of Rows Affected  : "+res);
		transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
	}
}
