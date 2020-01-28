package com.bcits.usecasemodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.dao.ConsumerDAO;

@Service
public class ConsumerServiceImplimentaion implements ConsumerService{
	@Autowired
	private ConsumerDAO dao;
	@Override
	public boolean addConsumer(ConsumerInfoBean conInfoBean , String cnfPassword) {
		System.out.println(conInfoBean);
		System.out.println(cnfPassword);
		if(!conInfoBean.getPassword().equals(cnfPassword)) {
			return false;
		}
		return dao.addConsumer(conInfoBean);
	}

}
