package com.bcits.jpawithhibernate.maping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.onetomany.EmployeeAddressPK;
import com.bcits.jpawithhibernateapp.bean.EmployeeAddressInfo;
import com.bcits.jpawithhibernateapp.bean.EmployeePrimaryInfo;

public class AddressOneToMany {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;

		EmployeeAddressPK addresspk = new EmployeeAddressPK();
		addresspk.setEmpid(320);
		addresspk.setAddress_type("permanent");
		
		EmployeeAddressPK addresspk1 = new EmployeeAddressPK();
		addresspk1.setEmpid(320);
		addresspk1.setAddress_type("Current");

		EmployeeAddressInfo address = new EmployeeAddressInfo();
		EmployeeAddressInfo address1 = new EmployeeAddressInfo();
		List<EmployeeAddressInfo> empaddress =new ArrayList<EmployeeAddressInfo>();
		
		EmployeePrimaryInfo primary_info = new EmployeePrimaryInfo();
		primary_info.setEmpid(320);
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
		
		address.setAdressPK(addresspk);
		address.setAddress1("herga");
		address.setAddress2("parkala");
		address.setHouse_no(454);
		address.setLandmark("Shani Temple");
		address.setCity("udupi");
		address.setPincode(576122);
		address.setPrimaryInfo(primary_info);
		
		address1.setAdressPK(addresspk1);
		address1.setAddress1("srinivas nagar");
		address1.setAddress2("basavangudi");
		address1.setHouse_no(475);
		address1.setLandmark("samsung showroom");
		address1.setCity("Bangalore");
		address1.setPincode(576000);
		address1.setPrimaryInfo(primary_info);
		
		
		empaddress.add(address);
		empaddress.add(address1);
		primary_info.setAddressinfo(empaddress);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(primary_info);
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
