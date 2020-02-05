package com.bcits.usecasemodule.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.usecasemodule.bean.TarrifMaster;

@Repository
public class GenerateBill {

	@PersistenceUnit
	private EntityManagerFactory emf;

	public double BillGenerate(long unit, String typeOfConsumer) {
		EntityManager manager = emf.createEntityManager();
		String jpql = " from TarrifMaster where type= :typeOfCons ";
		Query query = manager.createQuery(jpql);
		query.setParameter("typeOfCons", typeOfConsumer);
		List<TarrifMaster> tariffList = query.getResultList();

		long initRange = tariffList.get(0).getMasterPK().getRange();
		long midRange = tariffList.get(1).getMasterPK().getRange();
		long finalRange = tariffList.get(2).getMasterPK().getRange();

		double initAmount = tariffList.get(0).getAmount();
		double midAmount = tariffList.get(1).getAmount();
		double finalAmount = tariffList.get(2).getAmount();

		double bill = 0.0;

		if (unit < initRange) {
			bill = unit * initAmount;
		}else if(unit < midRange) {
			bill = ( initRange * initAmount) +((unit -initRange) * midAmount);
		}else if (unit > finalRange) {
			bill = (initRange * initAmount) +((midRange-initRange) * midAmount) +((unit - midRange) * finalAmount);
		}
		return bill;
	}
}
