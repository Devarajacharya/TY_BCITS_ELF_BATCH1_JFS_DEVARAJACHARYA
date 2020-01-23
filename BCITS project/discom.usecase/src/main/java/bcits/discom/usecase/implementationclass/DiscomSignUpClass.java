package bcits.discom.usecase.implementationclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bcits.discom.usecase.bean.ConsumerInfoBean;
import bcits.discom.usecase.factory.EntityManagerDAOFactory;

public class DiscomSignUpClass {

	public static boolean insertConsumerData(ConsumerInfoBean consumer) {
		EntityManagerFactory emf = EntityManagerDAOFactory.getDAOInstance();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(consumer);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
