package com.bcits.jpawithhibernateapp2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp2.bean.Test;

public class App 
{
    public static void main( String[] args ){ 
    	Test test = new Test();
    	test.setEmpid(200);
    	test.setEmpname("ragav");
    	test.setMobile_no(9007654326l);
    	test.setDOB(java.sql.Date.valueOf("2001-06-22") );
    	test.setDOJ(java.sql.Date.valueOf("2020-01-01") );
    	test.setDesignation("Tester");
    	test.setBlood_group("AB+");
    	test.setDeptid(40);
    	test.setManager_id(20);
    	test.setSal(33009.04);
    	test.setOfficial_mail("ragav578@gmail.com");
    	
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
