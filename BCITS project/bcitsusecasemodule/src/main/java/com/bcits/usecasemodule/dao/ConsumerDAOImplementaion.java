package com.bcits.usecasemodule.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;

@Repository
public class ConsumerDAOImplementaion implements ConsumerDAO{
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	@Override
	public boolean addConsumer(ConsumerInfoBean conInfoBean) {
		return false;
	}

}
