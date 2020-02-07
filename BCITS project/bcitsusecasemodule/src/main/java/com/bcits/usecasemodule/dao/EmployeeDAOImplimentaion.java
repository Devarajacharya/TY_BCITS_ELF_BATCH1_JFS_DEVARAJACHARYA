package com.bcits.usecasemodule.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.bean.MonthlyConsumption;
import com.bcits.usecasemodule.bean.MonthlyConsumptionPK;
import com.bcits.usecasemodule.bean.SupportBean;

@Repository
public class EmployeeDAOImplimentaion implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Autowired
	private GenerateBill genarateBill;
	
	@Override
	public EmployeeMasterInfo authentication(int empId, String password) {
		EntityManager manager = emf.createEntityManager();
		EmployeeMasterInfo empMasterInfo = manager.find(EmployeeMasterInfo.class, empId);
		System.out.println(empMasterInfo);
		if(empMasterInfo != null && empMasterInfo.getPassword().equals(password)){
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

	@Override
	public CurrentBill addCurrentBill(CurrentBill currentBill) {
		long unit =currentBill.getPresenceReading()-currentBill.getPreviousReading();
		EntityManager manager =emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		MonthlyConsumption monthlyConsumption = new MonthlyConsumption();
		MonthlyConsumptionPK monPk = new MonthlyConsumptionPK();
		CurrentBill bill = manager.find(CurrentBill.class, currentBill.getRrNumber());
		if(bill != null) {
			Calendar cal = Calendar.getInstance();
		  	cal.setTime(new Date());
		  	Calendar cal1 = Calendar.getInstance();
		  	cal1.setTime(bill.getStatementDate());
		  	if(cal.get(Calendar.MONTH) == cal1.get(Calendar.MONTH)) {
		  		return null;
		  	}
		}
		double amount = genarateBill.BillGenerate(unit,currentBill.getTypeOfConsumer());
			try {
			transaction.begin();
			if(bill != null) {
			manager.remove(bill);
			}
			monthlyConsumption.setBillAmount(amount);
			monthlyConsumption.setStatus("Not Paid");
			monthlyConsumption.setPrevReading(currentBill.getPreviousReading());
			monthlyConsumption.setPresReading(currentBill.getPresenceReading());
			monthlyConsumption.setUnitConsumed(unit);
			monPk.setDate(new Date());
			monPk.setRrNumber(currentBill.getRrNumber());
			monthlyConsumption.setConsumptionPk(monPk);
			currentBill.setBillAmount(amount);
			currentBill.setConsumption(unit);
			currentBill.setStatementDate(new Date());
			manager.persist(monthlyConsumption);
			manager.persist(currentBill);
			transaction.commit();
			return currentBill;
			}catch (Exception e) {
				return null;
			}
	}

	@Override
	public List<CurrentBill> getGeneratedBill(String region) {
		EntityManager manager = emf.createEntityManager();
		try {
		String jpql = " from CurrentBill where region= :reg "; 
		Query query =manager.createQuery(jpql);
		query.setParameter("reg", region);
		List<CurrentBill> currentBill = query.getResultList();
		return currentBill;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SupportBean> getComplaintsList(String region) {
		EntityManager manager = emf.createEntityManager();
		try {
			String jpql =" from SupportBean where region = :reg ";
			Query query =manager.createQuery(jpql);
			query.setParameter("reg", region);
			List<SupportBean> supportList = query.getResultList();
			if(supportList == null && supportList.isEmpty()) {
				return null;
			}
			return supportList;
			}catch (Exception e) {
				return null;
			}
		}

	@Override
	public boolean sendRespond(String rrNumber, String response) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		SupportBean supportBean = manager.find(SupportBean.class, rrNumber);
		if(supportBean != null) {
			try {
				transaction.begin();
				supportBean.setRequest(response);
				transaction.commit();
			}catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	
}







