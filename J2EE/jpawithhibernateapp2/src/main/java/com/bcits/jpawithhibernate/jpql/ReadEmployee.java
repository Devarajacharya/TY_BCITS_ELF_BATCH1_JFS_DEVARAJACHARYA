package com.bcits.jpawithhibernate.jpql;

import javax.persistence.Query;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadEmployee {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Test");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery(" from EmployeePrimaryInfo ");
		List<EmployeePrimaryInfo> list = query.getResultList();
		for (EmployeePrimaryInfo employeePrimaryInfo : list) {
			System.out.println("Employee ID   : " + employeePrimaryInfo.getEmpid());
			System.out.println("Employee Name : " + employeePrimaryInfo.getEmpname());
			System.out.println("Mobile Number : " + employeePrimaryInfo.getMobile_no());
			System.out.println("DOB           : " + employeePrimaryInfo.getDOB());
			System.out.println("DOJ           : " + employeePrimaryInfo.getDOJ());
			System.out.println("Designation   : " + employeePrimaryInfo.getDesignation());
			System.out.println("Boold Group   : " + employeePrimaryInfo.getBlood_group());
			System.out.println("Dept ID       : " + employeePrimaryInfo.getDeptid());
			System.out.println("Manager ID    : " + employeePrimaryInfo.getManager_id());
			System.out.println("Salary        : " + employeePrimaryInfo.getSal());
			System.out.println("Official Email: " + employeePrimaryInfo.getOfficial_mail());
			System.out.println();
		}
		manager.close();
	}
}
