package com.bcits.usecasemodule.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.usecasemodule.bean.BIllHistoryPK;
import com.bcits.usecasemodule.bean.BillHistory;
import com.bcits.usecasemodule.bean.ConsumerInfoBean;
import com.bcits.usecasemodule.bean.CurrentBill;
import com.bcits.usecasemodule.bean.MonthlyConsumption;

@Repository
public class ConsumerDAOImplementaion implements ConsumerDAO {

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
				if (email.equals(conInfoBean.getEmail())) {
					return false;
				}
			}
			manager.persist(conInfoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return false;
	}

	@Override
	public ConsumerInfoBean authentication(String email, String password) {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(" from ConsumerInfoBean where email= :email ");
		query.setParameter("email", email);
		ConsumerInfoBean conInfoBean = (ConsumerInfoBean) query.getSingleResult();
		if (conInfoBean != null && conInfoBean.getPassword().equals(password)) {
			return conInfoBean;
		}
		manager.close();
		return null;
	}

	@Override
	public CurrentBill getCurrentBill(String rrNumber) {
		EntityManager manager = emf.createEntityManager();
		CurrentBill currentBill = manager.find(CurrentBill.class, rrNumber);
		if (currentBill != null) {
			return currentBill;
		}
		manager.close();
		return null;
	}

	@Override
	public List<BillHistory> getBillHistory(String rrNumber) {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(" from BillHistory where rrNumber= :rrNum ");
		query.setParameter("rrNum", rrNumber);
		List<BillHistory> billList = query.getResultList();
		if (billList != null) {
			return billList;
		}
		manager.close();
		return null;
	}

	@Override
	public List<MonthlyConsumption> getMonthlyConsumptions(String rrNumber) {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(" from MonthlyConsumption where rrNumber= :rrNum");
		query.setParameter("rrNum", rrNumber);
		List<MonthlyConsumption> consumptionsList = query.getResultList();
		if (consumptionsList != null) {
			return consumptionsList;
		}
		manager.close();
		return null;
	}

	@Override
	public boolean billPayment(String rrNumber, Date date, double amount) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		BillHistory bill = new BillHistory();
		BIllHistoryPK billPk = new BIllHistoryPK();
		bill.setAmount(amount);
		bill.setStatus("Success");
		billPk.setPaymentDate(date);
		billPk.setRrNumber(rrNumber);
		bill.setBiHistoryPK(billPk);
		if (billPk != null) {
			transaction.begin();
			manager.persist(bill);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

}
