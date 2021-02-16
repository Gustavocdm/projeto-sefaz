package com.sefaz.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sefaz.model.Usuario;
import com.sefaz.repository.UsuarioRepository;

public class UsuarioService {

	UsuarioRepository usuarioRep;

	@Inject
	public UsuarioService(UsuarioRepository usuarioRep) {
		this.usuarioRep = usuarioRep;
	}

	public Usuario save(Usuario usuario) {
		// To Do
		return null;
	}

	public boolean remove(int id) {
		Usuario usuario = usuarioRep.findById(id);
		if(usuario == null) {
			return false;
		}
		usuarioRep.remove(usuario);
		return true;
	}

	public Usuario findById(int id) {
		return usuarioRep.findById(id);
	}

	public List<Usuario> findAll() {
		return usuarioRep.findAll();
	}

}
