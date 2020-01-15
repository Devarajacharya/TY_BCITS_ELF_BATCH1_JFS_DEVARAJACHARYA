package com.bcits.hibernate.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.hibernate.bean.EmployeePrimaryInfo;


public class FindEmployee {
	public static void main(String[] args) {
		try {
			EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("Test");
			EntityManager manager = entityManager.createEntityManager();
	        EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class,150);
			
			System.out.println("Employee ID   : "+info.getEmpid());
			System.out.println("Employee Name : "+info.getEmpname());
			System.out.println("Mobile Number : "+info.getMobile_no());
			System.out.println("DOB           : "+info.getDOB());
			System.out.println("DOJ           : "+info.getDOJ());
			System.out.println("Designation   : "+info.getDesignation());
			System.out.println("Boold Group   : "+info.getBlood_group());
			System.out.println("Dept ID       : "+info.getDeptid());
			System.out.println("Manager ID    : "+info.getManager_id());
			System.out.println("Salary        : "+info.getSal());
			System.out.println("Official Email: "+info.getOfficial_mail());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
