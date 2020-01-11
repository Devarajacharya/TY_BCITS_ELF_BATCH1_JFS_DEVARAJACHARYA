package com.bcits.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FindEmployeeName {


	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Test");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select empname from EmployeePrimaryInfo ");
		List<String> list = query.getResultList();
		for (String name : list) {
			System.out.println("Employee Name : " +name );
			System.out.println();
			
		}
		manager.close();
	}
}


