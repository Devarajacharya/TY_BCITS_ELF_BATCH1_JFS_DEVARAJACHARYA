package com.bcits.usecasemodule.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.springframework.stereotype.Repository;

import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.EmployeeMasterInfo;
import com.bcits.usecasemodule.bean.MonthlyConsumption;
import com.bcits.usecasemodule.bean.MonthlyConsumptionPK;

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

	@Override
	public boolean addCurrentBill(CurrentBill currentBill, double amount) {
		long unit =currentBill.getPresenceReading()-currentBill.getPreviousReading();
		EntityManager manager =emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		MonthlyConsumption monthlyConsumption = new MonthlyConsumption();
		MonthlyConsumptionPK monPk = new MonthlyConsumptionPK();
		CurrentBill bill = manager.find(CurrentBill.class, currentBill.getRrNumber());
		if(bill != null  && amount !=0) {
			transaction.begin();
			manager.remove(bill);
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
			manager.persist(monthlyConsumption);
			manager.persist(currentBill);
			transaction.commit();
			return true;
		}
		manager.close();
		return false;
	}

	
}







