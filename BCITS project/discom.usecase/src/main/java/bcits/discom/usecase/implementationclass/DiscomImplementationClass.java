package bcits.discom.usecase.implementationclass;

import javax.persistence.EntityManager;

import bcits.discom.usecase.factory.DiscomDAO;
import bcits.discom.usecase.factory.EntityManagerDAOFactory;

public class DiscomImplementationClass implements DiscomDAO{
	@Override
	public void insertAllDate() {
		EntityManager manager = EntityManagerDAOFactory.getDAOInstance();
		
		
	}
}
