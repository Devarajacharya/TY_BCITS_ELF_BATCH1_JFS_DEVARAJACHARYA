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
import com.bcits.usecasemodule.bean.SupportBean;
import com.bcits.usecasemodule.bean.SupportBeanPK;

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
	public boolean billPayment(String rrNumber, Date date, double amount,String region) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql =" from MonthlyConsumption where rrNumber=:rrNum order by presReading DESC";
		Query query = manager.createQuery(jpql);
		query.setMaxResults(1);
		query.setParameter("rrNum", rrNumber);
		MonthlyConsumption monthlyConsumption = (MonthlyConsumption) query.getSingleResult();

		BillHistory bill = new BillHistory();
		BIllHistoryPK billPk = new BIllHistoryPK();
		bill.setAmount(amount);
		bill.setStatus("Success");
		billPk.setPaymentDate(date);
		billPk.setRrNumber(rrNumber);
		bill.setBiHistoryPK(billPk);
		bill.setRegion(region);
		if (billPk != null) {
			transaction.begin();
			monthlyConsumption.setStatus("paid");
			manager.persist(bill);
			transaction.commit();
			return true;
		} 
			return false;
	}

	@Override
	public boolean changePassword(String password, String rrNumber) {
		EntityManager manager =emf.createEntityManager();
		ConsumerInfoBean consumerInfoBean = manager.find(ConsumerInfoBean.class, rrNumber);
		EntityTransaction transaction =  manager.getTransaction();
		if(consumerInfoBean != null) {
		transaction.begin();
		consumerInfoBean.setPassword(password);
		transaction.commit();
		return true;
		}
		return false;
	}

	@Override
	public ConsumerInfoBean getConsumer(String rrNumber) {
		EntityManager manager = emf.createEntityManager();
		ConsumerInfoBean conInfoBean = manager.find(ConsumerInfoBean.class, rrNumber);
		if(conInfoBean != null) {
			return conInfoBean;
		}
		manager.close();
		return null;
	}

	@Override
	public long getPreviousReading(String rrNumber) {
		EntityManager manager = emf.createEntityManager();
		long previous;
		try {
		String jpql =" select presReading from MonthlyConsumption where rrNumber=:rrNum order by presReading DESC";
		Query query = manager.createQuery(jpql);
		query.setMaxResults(1);
		query.setParameter("rrNum", rrNumber);
		previous = (long) query.getSingleResult();
		}catch (Exception e) {
			return 0;
		}
		if(previous != 0) {
			return previous;
		}
		return 0;
	}

	@Override
	public boolean setRequestMsg(String request,String rrNumber,String region) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		SupportBean supportBean = new SupportBean();
		SupportBeanPK supportBeanPK = new SupportBeanPK();
		try {
			transaction.begin();
			supportBeanPK.setRrNumber(rrNumber);
			supportBean.setRegion(region);
			supportBeanPK.setDate(new Date());
			supportBean.setRequest(request);
			supportBean.setSupport("-------");
			supportBean.setSupportBeanPK(supportBeanPK);
			manager.persist(supportBean);
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<SupportBean> getResponse(String rrNumber) {
		EntityManager manager = emf.createEntityManager();
			try {
				String jpql=" from SupportBean where rrNumber= :rrNum ";
				Query query =manager.createQuery(jpql);
				query.setParameter("rrNum", rrNumber);
				List<SupportBean> supportBean =query.getResultList();
				return supportBean;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;

	}

}



















