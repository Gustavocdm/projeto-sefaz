package org.sefaz.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class ConnectionDB {
	final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
	
	public EntityManager getEntityManager() {
		return this.entityManagerFactory.createEntityManager();
	}
	
	
}
