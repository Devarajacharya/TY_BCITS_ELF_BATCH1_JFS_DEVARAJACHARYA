package com.bcits.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springmvc.bean.EmployeeInfoBean;

@Repository
public class EmployeeDAOImplimentaionClass implements EmployeeDAO {
	@PersistenceUnit
	private EntityManagerFactory emf;
	@Override
	public boolean addEmployee(EmployeeInfoBean empBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(empBean);
			transaction.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		EmployeeInfoBean empInfo = manager.find(EmployeeInfoBean.class, empId);
		if (empInfo != null) {
			try {
				transaction.begin();
				manager.remove(empInfo);
				transaction.commit();
				return true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				manager.close();
			}
		}
		return false;
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean empBean) {
		EntityManager manager = emf.createEntityManager();

		return false;
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		EntityManager manager = emf.createEntityManager();
		EmployeeInfoBean empInfo = manager.find(EmployeeInfoBean.class, empId);
		manager.close();
		return empInfo;
	}

	@Override
	public List<EmployeeInfoBean> getAllEMployee() {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(" from EmployeePrimaryInfo ");
		List<EmployeeInfoBean> empInfo = query.getResultList();
		manager.close();
		return empInfo;

	}

	@Override
	public EmployeeInfoBean authentication(int empId, String password) {
		EntityManager manager = emf.createEntityManager();
		EmployeeInfoBean empInfo = manager.find(EmployeeInfoBean.class, empId);

		if (empInfo != null && empInfo.getPassword().equals(password)) {
			return empInfo;
		}
		return null;
	}

}
