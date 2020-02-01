package com.bcits.usecasemodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.dao.ConsumerDAO;
import com.bcits.usecasemodule.validation.FormValidation;

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
	@Override
	public ConsumerInfoBean authentication(String email, String password) {
		if(email.isEmpty() && password.isEmpty()) {
			return null;
		}
		return dao.authentication(email, password);
	}
	@Override
	public CurrentBill getCurrentBill(String rrNumber) {
		if(FormValidation.rrValidation(rrNumber)) {
			return null;
		}
		return dao.getCurrentBill(rrNumber);
	}

}
