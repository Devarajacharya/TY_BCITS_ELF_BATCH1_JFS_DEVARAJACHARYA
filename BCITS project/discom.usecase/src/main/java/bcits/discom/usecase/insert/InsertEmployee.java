package bcits.discom.usecase.insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import bcits.discom.usecase.bean.EmployeeMasterInfo;


public class InsertEmployee {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		EmployeeMasterInfo empInfo = new EmployeeMasterInfo();
		empInfo.setEmpId(12300);
		empInfo.setEmpName("Raghu R");
		empInfo.setDesignation("manager");
		empInfo.setRegion("Bangalore South");
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("discomPersistenceUnit");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(empInfo);
			System.out.println("Record Saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}
}

