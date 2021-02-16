package com.sefaz.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.sefaz.connection.ConnectionDB;

import com.sefaz.model.Telefone;

public class TelefoneRepository {

EntityManager entityManager;
	
	@Inject
	public TelefoneRepository(ConnectionDB con) {
		this.entityManager = con.getEntityManager();
	}
	
	public Telefone findById(int id) {
		return entityManager.find(Telefone.class, id);
	}
	
	public List<Telefone> findAll() {
		return entityManager.createQuery("from telefone").getResultList();		
	}
	
	public boolean remove(Telefone telefone) {
		entityManager.remove(telefone);
		return true;
	}
	
	public Telefone save(Telefone telefone) {
		try {
	        entityManager.getTransaction().begin();
	        entityManager.persist(telefone);
	        entityManager.getTransaction().commit();
	        return telefone;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public List<Telefone> saveMany(List<Telefone> telefones) {
		try {
	        entityManager.getTransaction().begin();
	        for(Telefone telefone : telefones) {	        	
	        	entityManager.persist(telefone);
	        }
	        entityManager.getTransaction().commit();
	        return telefones;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
