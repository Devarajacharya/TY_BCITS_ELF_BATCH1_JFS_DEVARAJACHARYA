package com.bcits.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.bean.Test;

public class App {
	public static void main(String[] args) {

		Test test = new Test();
		test.setId(2);
		test.setMovieName("KGF");
		test.setMovieRating("Best");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transation = manager.getTransaction();
		transation.begin();
		manager.persist(test);
		System.out.println("Record Saved");
		transation.commit();
		manager.close();

	}
}
