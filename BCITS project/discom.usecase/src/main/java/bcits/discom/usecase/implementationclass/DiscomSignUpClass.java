package bcits.discom.usecase.implementationclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import bcits.discom.usecase.bean.ConsumerInfoBean;
import bcits.discom.usecase.factory.EntityManagerDAOFactory;

public class DiscomSignUpClass {

	public static boolean insertConsumerData(ConsumerInfoBean consumer) {
		EntityManager manager = EntityManagerDAOFactory.getDAOInstance();
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
