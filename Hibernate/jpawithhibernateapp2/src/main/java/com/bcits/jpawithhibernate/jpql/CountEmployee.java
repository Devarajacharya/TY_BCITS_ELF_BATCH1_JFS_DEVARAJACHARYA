package com.bcits.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CountEmployee {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Test");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select count(empname) from EmployeePrimaryInfo ");
		Object res = query.getSingleResult();
		System.out.println("number of Count is "+ res);
		manager.close();
	}
}
