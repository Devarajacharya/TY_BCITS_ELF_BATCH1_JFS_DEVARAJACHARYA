package com.bcits.usecasemodule.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;

@Repository
public class EmployeeDAOImplimentaion implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public EmployeeMasterInfo authentication(int empId, String designation) {
		EntityManager manager = emf.createEntityManager();
		EmployeeMasterInfo empMasterInfo = manager.find(EmployeeMasterInfo.class, empId);
		if(empMasterInfo != null && empMasterInfo.getDesignation().equals(designation)) {
			return empMasterInfo;
		}
		return null;
	}

	@Override
	public List<ConsumerInfoBean> getAllConsumer(String region) {
		EntityManager manager = emf.createEntityManager();
		String jpql = " from ConsumerInfoBean where region= :reg ";
		Query query =manager.createQuery(jpql);
		query.setParameter("reg", region);
		List<ConsumerInfoBean> consList = (List<ConsumerInfoBean>) query.getResultList();
		if(consList != null) {
			return consList;
		}
		return null;
	}

	@Override
	public long countConsumer(String region) {
		EntityManager manager =emf.createEntityManager();
		String jpql ="select count(*) from ConsumerInfoBean where region= :reg ";
		Query query =manager.createQuery(jpql);
		query.setParameter("reg", region);
		long count = (long) query.getSingleResult();
		if(count != 0) {
			return count;
		}
		return 0;
	}

	
}
