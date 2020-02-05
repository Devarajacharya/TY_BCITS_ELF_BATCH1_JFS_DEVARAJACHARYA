package com.bcits.usecasemodule.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.usecasemodule.bean.AdminInfo;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;

@Repository
public class AdminDAOImplementation implements AdminDAO {
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	@Override
	public AdminInfo authenticate(String username, String password) {
	EntityManager manager = emf.createEntityManager();
	AdminInfo adminInfo = manager.find(AdminInfo.class, username);
	if(adminInfo != null && adminInfo.getPassword().equals(password)) {
		return adminInfo;
	}
	manager.close();
		return null;
	}
	@Override
	public boolean addEMployee(EmployeeMasterInfo empInfo) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(empInfo);
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
	return false;
	}

}
