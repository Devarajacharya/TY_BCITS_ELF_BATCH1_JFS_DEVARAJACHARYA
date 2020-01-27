package com.bcits.jpawithhibernate.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.hibernate.bean.EmployeeAddressInfo;
import com.bcits.hibernate.bean.EmployeePrimaryInfo;


public class OneToMany {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		EmployeePrimaryInfo primary_info = new EmployeePrimaryInfo();

		EmployeeAddressPK addresspk = new EmployeeAddressPK();
		addresspk.setEmpid(270);
		addresspk.setAddress_type("permanent");
		
		EmployeeAddressPK addresspk1 = new EmployeeAddressPK();
		addresspk1.setEmpid(270);
		addresspk1.setAddress_type("current");
		
		EmployeeAddressInfo address = new EmployeeAddressInfo();
		address.setAdresspk(addresspk);
		address.setAddress1("herge");
		address.setAddress2("parkala");
		address.setHouse_no(454);
		address.setLandmark("Bhobharya gatte");
		address.setCity("Udupi");
		address.setPincode(576101);
		address.setPrimaryInfo(primary_info);

		EmployeeAddressInfo address1 = new EmployeeAddressInfo();
		address1.setAdresspk(addresspk1);
		address1.setAddress1("Srinivas nagar");
		address1.setAddress2("basavangudi");
		address1.setHouse_no(110);
		address1.setLandmark("Samsung showroom");
		address1.setCity("Banglore");
		address1.setPincode(579994);
		address.setPrimaryInfo(primary_info);

		
		List<EmployeeAddressInfo> empAddress =new ArrayList<EmployeeAddressInfo>();
		empAddress.add(address);
		empAddress.add(address1);

		primary_info.setEmpid(230);
		primary_info.setEmpname("jaggu");
		primary_info.setMobile_no(8000009361l);
		primary_info.setDOB(java.sql.Date.valueOf("1987-03-22"));
		primary_info.setDOJ(java.sql.Date.valueOf("2013-01-21"));
		primary_info.setDesignation("Developer");
		primary_info.setBlood_group("AB-");
		primary_info.setDeptid(30);
		primary_info.setManager_id(50);
		primary_info.setSal(22300.54);
		primary_info.setOfficial_mail("jaggu578@gmail.com");
		primary_info.setAddressinfo(empAddress);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			
			/*
			 * EmployeePrimaryInfo pr = manager.find(EmployeePrimaryInfo.class, 270);
			 * address.setPrimaryInfo(pr);
			 */
//			EmployeePrimaryInfo pr = manager.find(EmployeePrimaryInfo.class, 270);
//			System.out.println(pr.getAddressinfo().get(0).getAddress1());
//			System.out.println(pr.getAddressinfo().get(0).getAddress2());
			manager.persist(address);
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
