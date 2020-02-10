package com.bcits.usecasemodule.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.usecasemodule.bean.BillHistory;
import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.bean.MonthlyConsumption;
import com.bcits.usecasemodule.bean.SupportBean;
import com.bcits.usecasemodule.dao.EmployeeDAO;
import com.bcits.usecasemodule.mail.MailGenerator;
import com.bcits.usecasemodule.validation.FormValidation;

@Service
public class EmployeeServiceImplimentation implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Autowired
	private ConsumerService consumerService;

	private MailGenerator mail = new MailGenerator();

	@Override
	public EmployeeMasterInfo authentication(int empId, String password) {
		if (empId < 1 && password.isEmpty()) {
			return null;
		}
		return dao.authentication(empId, password);
	}

	@Override
	public List<ConsumerInfoBean> getAllConsumer(String region) {
		return dao.getAllConsumer(region);
	}

	@Override
	public long countConsumer(String region) {
		return dao.countConsumer(region);
	}

	@Override
	public CurrentBill addCurrentBill(CurrentBill currentBill, String region) {
		if (currentBill != null && (currentBill.getPreviousReading() < currentBill.getPresenceReading())) {
			CurrentBill currentBill2 = dao.addCurrentBill(currentBill, region);
			if (currentBill2 != null) {
				ConsumerInfoBean consumerInfoBean = consumerService.getConsumer(currentBill.getRrNumber());
				mail.sendMail(currentBill2, consumerInfoBean);
				return currentBill2;
			}
		}
		return null;
	}

	@Override
	public List<CurrentBill> getGeneratedBill(String region) {
		if (region != null) {
			return dao.getGeneratedBill(region);
		}
		return null;
	}

	@Override
	public List<SupportBean> getComplaintsList(String region) {
		if (region != null) {
			return dao.getComplaintsList(region);
		}
		return null;
	}

	@Override
	public boolean sendRespond(String rrNumber, String response, Date date) {
		return dao.sendRespond(rrNumber, response, date);
	}

	@Override
	public List<MonthlyConsumption> getCollectedBill(String region) {
		if (region != null) {
			return dao.getCollectedBill(region);
		}
		return null;
	}

	@Override
	public List<BillHistory> getBillList(String region) {
		if (region != null) {
			return dao.getBillList(region);
		}
		return null;
	}
}