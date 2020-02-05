package com.bcits.usecasemodule.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecasemodule.bean.BillHistory;
import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.MonthlyConsumption;
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
	@Override
	public List<BillHistory> getBillHistory(String rrNumber) {
		if(FormValidation.rrValidation(rrNumber)) {
			return null;
		}
		return dao.getBillHistory(rrNumber);
	}
	@Override
	public List<MonthlyConsumption> getMonthlyConsumptions(String rrNumber) {
		if(FormValidation.rrValidation(rrNumber)) {
			return null;
		}
		return dao.getMonthlyConsumptions(rrNumber);
	}
	@Override
	public boolean billPayment(String rrNumber, Date date, double amount) {
		if(FormValidation.rrValidation(rrNumber)) {
			return false;
		}
		System.out.println(amount +"ghfdtg");
		return dao.billPayment(rrNumber, date,amount);
	}
	@Override
	public boolean changePassword(String password, String confPassword,String rrNumber) {
		if(FormValidation.rrValidation(rrNumber)) {
			return false;
		}
		if(!password.equals(confPassword)) {
			return false;
		}
		return dao.changePassword(password,rrNumber); 
	}
	@Override
	public ConsumerInfoBean getConsumer(String rrNumber) {
		if(FormValidation.rrValidation(rrNumber)) {
			return null;
		}
		return dao.getConsumer(rrNumber);
	}
	@Override
	public long getPreviousReading(String rrNumber) {
		if(FormValidation.rrValidation(rrNumber)) {
			return 0;
		}
		return dao.getPreviousReading(rrNumber);
	}
	@Override
	public boolean setSupportMsg(String support , String rrNumber ,String region) {
		if(support != null && !support.isEmpty()) {
			return dao.setSupportMsg(support,rrNumber,region);
		}
		return false;
	}

}
