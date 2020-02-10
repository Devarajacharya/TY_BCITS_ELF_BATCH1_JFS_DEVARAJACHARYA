package com.bcits.springsecurityrest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springsecurityrest.beans.EmployeeInfoBean;

@Repository
public class EmpDAOImplimentaion implements EmpDAO{
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean register(EmployeeInfoBean employeeInfoBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction  transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(employeeInfoBean);
			transaction.commit();
			return true;
		}catch (Exception e) {
		}finally {
			manager.close();
		}
		return false;
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		EntityManager manager = emf.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		if(employeeInfoBean != null) {
			return employeeInfoBean;
		}
		manager.close();
		return null;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(" from EmployeeInfoBean ");
		List<EmployeeInfoBean> empList = query.getResultList();
		if(empList != null) {
			return empList;
		}
		manager.close();
		return null;
	}

}
