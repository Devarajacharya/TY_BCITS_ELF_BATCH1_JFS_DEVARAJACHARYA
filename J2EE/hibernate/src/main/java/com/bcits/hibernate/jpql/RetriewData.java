package com.bcits.hibernate.jpql;

import javax.persistence.Query;

import com.bcits.hibernate.bean.EmployeePrimaryInfo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RetriewData {

	public static void main(String[] args) {
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("Test");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery(" from EmployeePrimaryInfo ");
		List<EmployeePrimaryInfo> list = query.getResultList();
		for (EmployeePrimaryInfo info : list) {
			System.out.println("Employee ID    : "+info.getEmpid());
			System.out.println("Employee Sal   : "+info.getSal());
			}
	}
}
