package com.bcits.usecasemodule.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;

@Repository
public class ConsumerDAOImplementaion implements ConsumerDAO{
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	@Override
	public boolean addConsumer(ConsumerInfoBean conInfoBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(conInfoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return false;
	}

}
