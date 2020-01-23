package bcits.discom.usecase.factory;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerDAOFactory {
	private static EntityManager  manager = null;
	private EntityManagerDAOFactory() {}
	
	public static EntityManager getDAOInstance() {
		if(manager == null ) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("discomPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		}
		return manager;	
	}
	
}
