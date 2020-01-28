package com.bcits.usecasemodule.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.usecasemodule.bean.EmployeeMasterInfo;

@Repository
public class EmployeeDAOImplimentaion implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public EmployeeMasterInfo authentication(int empId, String designation) {
		EntityManager manager = emf.createEntityManager();
		EmployeeMasterInfo empMasterInfo = manager.find(EmployeeMasterInfo.class, empId);
		if(empId == empMasterInfo.getEmpId() && empMasterInfo.getDesignation().equals(designation)) {
			return empMasterInfo;
		}
		return null;
	}

}
