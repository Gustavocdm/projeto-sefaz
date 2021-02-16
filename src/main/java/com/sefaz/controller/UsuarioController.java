package com.sefaz.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sefaz.model.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
