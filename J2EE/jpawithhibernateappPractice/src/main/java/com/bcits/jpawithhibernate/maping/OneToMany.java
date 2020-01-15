package com.bcits.jpawithhibernate.maping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

public class OneToMany {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			EmployeePrimaryInfo pr = manager.find(EmployeePrimaryInfo.class, 270);
			
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
