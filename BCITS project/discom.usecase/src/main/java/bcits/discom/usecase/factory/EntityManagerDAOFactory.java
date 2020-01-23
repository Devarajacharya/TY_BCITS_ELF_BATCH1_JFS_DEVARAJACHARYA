package bcits.discom.usecase.factory;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerDAOFactory {
	private static EntityManagerFactory  emf = null;
	private EntityManagerDAOFactory() {}
	
	public static EntityManagerFactory getDAOInstance() {
		if(emf == null ) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("discomPersistenceUnit");
		}
		return emf;	
	}
	
}
