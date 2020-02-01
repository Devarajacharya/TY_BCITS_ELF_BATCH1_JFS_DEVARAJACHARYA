package com.bcits.usecasemodule.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;

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
			String jpql = "select email from ConsumerInfoBean ";
			Query query = manager.createQuery(jpql);
			List<String> emailList = query.getResultList();
			for (String email : emailList) {
				if(email.equals(conInfoBean.getEmail())) {
					return false;
				}
			}
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
	
	@Override
	public ConsumerInfoBean authentication(String email, String password) {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(" from ConsumerInfoBean where email= :email ");
		query.setParameter("email",email);
		ConsumerInfoBean conInfoBean = (ConsumerInfoBean) query.getSingleResult();
		if(conInfoBean != null && conInfoBean.getPassword().equals(password)) {
			return conInfoBean;
		}
		return null;
	}
	
	@Override
	public CurrentBill getCurrentBill(String rrNumber) {
		EntityManager manager = emf.createEntityManager();
		CurrentBill currentBill = manager.find(CurrentBill.class, rrNumber);
		if(currentBill != null) {
			return currentBill;
		}
		return null;
	}

}
