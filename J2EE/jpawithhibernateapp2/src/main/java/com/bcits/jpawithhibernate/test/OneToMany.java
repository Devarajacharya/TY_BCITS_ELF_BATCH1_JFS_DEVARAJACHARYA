package com.bcits.jpawithhibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.maytoone.EmployeeAddressPK;
import com.bcits.jpawithhibernate.maytoone.EmployeeAddressInfo;
import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

public class OneToMany {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;

		EmployeeAddressPK addresspk = new EmployeeAddressPK();
		addresspk.setEmpid(270);
		addresspk.setAddress_type("permanent");

		EmployeePrimaryInfo primary_info = new EmployeePrimaryInfo();
		primary_info.setEmpid(270);
		primary_info.setEmpname("rajdheep");
		primary_info.setMobile_no(8868009361l);
		primary_info.setDOB(java.sql.Date.valueOf("1991-03-22"));
		primary_info.setDOJ(java.sql.Date.valueOf("2019-01-21"));
		primary_info.setDesignation("Tester");
		primary_info.setBlood_group("AB+");
		primary_info.setDeptid(40);
		primary_info.setManager_id(20);
		primary_info.setSal(65300.54);
		primary_info.setOfficial_mail("rajdheep578@gmail.com");

		EmployeeAddressInfo address = new EmployeeAddressInfo();
		address.setAdressPK(addresspk);
		address.setAddress1("mahakali road");
		address.setAddress2("Manglore");
		address.setHouse_no(454);
		address.setLandmark("Shani Temple");
		address.setCity("Manglore");
		address.setPincode(576124);
		address.setPrimaryInfo(primary_info);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			
			/*
			 * EmployeePrimaryInfo pr = manager.find(EmployeePrimaryInfo.class, 270);
			 * address.setPrimaryInfo(pr);
			 */
			EmployeePrimaryInfo pr = manager.find(EmployeePrimaryInfo.class, 270);
			System.out.println(pr.getAddressinfo().get(0).getAddress1());
			System.out.println(pr.getAddressinfo().get(0).getAddress2());
//			manager.persist(address);
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
