package com.bcits.jpawithhibernate.jpql;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicDelete {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Scanner sd = null;
		try {
		factory = Persistence.createEntityManagerFactory("Test");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		String jpql = "Delete from EmployeePrimaryInfo where empid = :id ";
		Query query = manager.createQuery(jpql);
		sd = new Scanner(System.in);
		System.out.println("Enter Employee Id to Delete : ");
		int num = sd.nextInt();
		query.setParameter("id", num);
		int res = query.executeUpdate();
		System.out.println("Number of Rows Affected  : "+res);
		transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
			sd.close();
			
		}
	}
}
