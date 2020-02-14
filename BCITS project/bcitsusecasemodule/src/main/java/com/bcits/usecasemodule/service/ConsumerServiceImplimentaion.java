package com.bcits.usecasemodule.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecasemodule.bean.BillHistory;
import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.MonthlyConsumption;
import com.bcits.usecasemodule.bean.SupportBean;
import com.bcits.usecasemodule.dao.ConsumerDAO;
import com.bcits.usecasemodule.mail.PaymentMail;
import com.bcits.usecasemodule.validation.FormValidation;
import com.bcits.usecasemodule.validation.signUpValidationForm;

@Service
public class ConsumerServiceImplimentaion implements ConsumerService {
	@Autowired
	private ConsumerDAO dao;
	
	private FormValidation validation = new FormValidation();
	private PaymentMail mail = new PaymentMail();

	@Override
	public boolean addConsumer(ConsumerInfoBean conInfoBean, String cnfPassword) {

		if (signUpValidationForm.signUpValidation(conInfoBean)) {
			return false;
		} else if (!conInfoBean.getPassword().equals(cnfPassword)) {
			return false;
		}
		return dao.addConsumer(conInfoBean);
	}

	@Override
	public ConsumerInfoBean authentication(String email, String password) {

		if (email.isEmpty() && password.isEmpty()) {
			return null;
		} else if (validation.emailValidation(email)) {
			return null;
		}
		return dao.authentication(email, password);
	}

	@Override
	public CurrentBill getCurrentBill(String rrNumber) {

		if (validation.rrValidation(rrNumber)) {
			return null;
		}
		return dao.getCurrentBill(rrNumber);
	}

	@Override
	public List<BillHistory> getBillHistory(String rrNumber) {

		if (validation.rrValidation(rrNumber)) {
			return null;
		}
		return dao.getBillHistory(rrNumber);
	}

	@Override
	public List<MonthlyConsumption> getMonthlyConsumptions(String rrNumber) {

		if (validation.rrValidation(rrNumber)) {
			return null;
		}
		return dao.getMonthlyConsumptions(rrNumber);
	}

	@Override
	public boolean billPayment(String rrNumber, Date date, double amount, String region) {

		if (validation.rrValidation(rrNumber)) {
			return false;
		} else if (validation.regionValidation(region)) {
			return false;
		} else if (validation.amountValidation(amount)) {
			return false;
		} else {
			if (dao.billPayment(rrNumber, date, amount, region)) {
				ConsumerInfoBean consumerInfoBean = dao.getConsumer(rrNumber);
				mail.successfullPaymentMail(amount, consumerInfoBean);
				return true;
			}
			return false;
		}
	}

	@Override
	public boolean changePassword(String password, String confPassword, String rrNumber) {

		if (validation.rrValidation(rrNumber)) {
			return false;
		} else if (!password.equals(confPassword)) {
			return false;
		} else {
			return dao.changePassword(password, rrNumber);
		}
	}

	@Override
	public ConsumerInfoBean getConsumer(String rrNumber) {

		if (validation.rrValidation(rrNumber)) {
			return null;
		}
		return dao.getConsumer(rrNumber);
	}

	@Override
	public long getPreviousReading(String rrNumber) {

		if (validation.rrValidation(rrNumber)) {
			return 0;
		}
		return dao.getPreviousReading(rrNumber);
	}

	@Override
	public boolean setRequestMsg(String request, String rrNumber, String region) {

		if (validation.requetValidation(request) || validation.rrValidation(rrNumber) || validation.regionValidation(region)) {
			return false;
		}  else {
			return dao.setRequestMsg(request, rrNumber, region);
		}
	}

	@Override
	public List<SupportBean> getResponse(String rrNumber) {

		if (validation.rrValidation(rrNumber)) {
			return null;
		}
		return dao.getResponse(rrNumber);
	}

}
