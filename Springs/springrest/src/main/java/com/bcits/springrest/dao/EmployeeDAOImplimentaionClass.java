package com.bcits.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springrest.beans.EmployeeInfoBean;

@Repository
public class EmployeeDAOImplimentaionClass implements EmployeeDAO {
	@PersistenceUnit
	private EntityManagerFactory emf;

//	@PersistenceContext
//	private EntityManager manager;

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
		EntityTransaction transaction = manager.getTransaction();
		int empId = empBean.getEmpid();
		EmployeeInfoBean empInfo = manager.find(EmployeeInfoBean.class, empId);
		if (empInfo != null) {
			try {
				transaction.begin();
				if (empBean.getEmpname() != null) {
					empInfo.setEmpname(empBean.getEmpname());
				}
				if (empBean.getSal() != null && empBean.getSal() > 0 ) {
					empInfo.setSal(empBean.getSal());
				}
				if (empBean.getDesignation() != null) {
					empInfo.setDesignation(empBean.getDesignation());
				}
				if (!empBean.getBloodGroup().isEmpty()) {
					empInfo.setBloodGroup(empBean.getBloodGroup());
				}
				if (empBean.getDOB() != null) {
					empInfo.setDOB(empBean.getDOB());
				}
				if (empBean.getDOJ() != null) {
					empInfo.setDOJ(empBean.getDOJ());
				}
				if (empBean.getMobileNo() != null) {
					empInfo.setMobileNo(empBean.getMobileNo());
				}
				if(!empBean.getPassword().isEmpty()) {
				empInfo.setPassword(empBean.getPassword());
				}
				if (empBean.getManagerId() != null) {
					empInfo.setManagerId(empBean.getManagerId());

				}
				if(empBean.getDeptId() != null) {
				empInfo.setDeptId(empBean.getDeptId());
				}
				if(!empBean.getOfficialMail().isEmpty()) {
				empInfo.setOfficialMail(empBean.getOfficialMail());
				}
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
	public EmployeeInfoBean getEmployee(int empId) {
		EntityManager manager = emf.createEntityManager();
		EmployeeInfoBean empInfo = manager.find(EmployeeInfoBean.class, empId);
		manager.close();
		return empInfo;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(" from EmployeeInfoBean ");
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
