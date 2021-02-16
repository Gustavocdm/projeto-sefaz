package com.sefaz.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.sefaz.connection.ConnectionDB;

import com.sefaz.model.Usuario;

public class UsuarioRepository {
	
	EntityManager entityManager;
	
	@Inject
	public UsuarioRepository(ConnectionDB con) {
		entityManager = con.getEntityManager();
	}
	
	public Usuario findById(int id) {
		return entityManager.find(Usuario.class, id);
	}
	
	public List<Usuario> findAll() {
		return entityManager.createQuery("from usuario").getResultList();		
	}
	
	public boolean remove(Usuario usuario) {
		entityManager.remove(usuario);
		return true;
	}
	
	public Usuario save(Usuario usuario) {
		try {
	        entityManager.getTransaction().begin();
	        entityManager.persist(usuario);
	        entityManager.getTransaction().commit();
	        return usuario;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
